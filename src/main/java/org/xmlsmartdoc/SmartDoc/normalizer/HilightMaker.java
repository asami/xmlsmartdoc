/*
 * SmartDoc : Ultimate document format based on XML
 *	Copyright (C) 1998-2004	 ASAMI, Tomoharu (asami@xmlSmartdoc.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.	 See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.*;
import org.apache.oro.text.perl.Perl5Util; // revised by asami
import org.apache.oro.text.regex.MatchResult;
import com.AsamiOffice.text.UString;
import org.xmlsmartdoc.SmartDoc.*;
import org.xmlsmartdoc.SmartDoc.normalizer.hilight.*;

/**
 * HilightMaker
 * 
 * @since	Jul. 16, 2000
 * @version Jan. 25, 2004
 * @author	SAKURAI, Masashi (m.sakurai@dream.com)
 */
public class HilightMaker {

	private List keywordList;

	private Perl5Util perl5Util = new Perl5Util();
	private TreeSet keywordTree = new TreeSet();
	private ArrayList tempList = new ArrayList();

	/**
	   Construct hilight class.
	   Once construct this object, other routine can re-use to 
	   call [makeHilight] method.

	   @param keywords	 keyword matrix [group][keywords]
	   @param isRegex	 is each group Regex? [group]
	   @param keyClasses class name in charge of tag [group]
	*/
	public HilightMaker(String [][] keywords,boolean [] isRegex,
						String [] keyClasses) {
		keywordList = new LinkedList();
		for (int i=0;i<keyClasses.length;i++) {
			for (int j=0;j<keywords[i].length;j++) {
				Keyword m = new Keyword(keywords[i][j],isRegex[i],
										keyClasses[i]);
				keywordList.add(m);
			}
		}
	}

	/**
	   Construct hilight class from hilight data.
	   Once construct this object, other routine can re-use to 
	   call [makeHilight] method.

	   @param syntax  hilight syntax data 
	   @see org.xmlsmartdoc.SmartDoc.normalizer.hilight.Syntax
	*/
	public HilightMaker(Syntax syntax) {
		keywordList = new LinkedList();
		for (int i=0;i<syntax.getWordCount();i++) {
			Word word = syntax.getWord(i);
			if (word.getRegex()) {
				for (int j=0;j<word.getExpressionCount();j++) {
					keywordList.add( new Keyword
						(word.getExpression(j),
						 true,word.getTagClass(),
						 word.getCssClass()) );
				}
			} else {
				for (int j=0;j<word.getExpressionCount();j++) {
					String [] tokens = 
						UString.getTokens(word.getExpression(j),",");
					for (int k=0;k<tokens.length;k++) {
						keywordList.add( new Keyword
							(tokens[k],false,word.getTagClass(),
							 word.getCssClass()) );
					}
				}
			}
		}
	}

	/** 
		make syntax hilighting
		@param text input plain text
		@param list operated text list
	*/
	public void makeHilight(String text,List list) {
		//ready
		keywordTree.clear();
		Iterator it = keywordList.iterator();
		while(it.hasNext()) {
			Keyword key = (Keyword)it.next();
			if (search(perl5Util,text,key)) {
				keywordTree.add(key);
			}
		}

		while( !keywordTree.isEmpty() ) {
			Keyword res = (Keyword)keywordTree.first();
			if (res.ps == -1) break;//error?
			if (res.ps > 0) {
				list.add(new CharBlock(text.substring(0, res.ps)));
			}
			list.add(res.getContent());
			if (res.end <= text.length()) {
				text = text.substring(res.end);
			} else {
				System.err.println("Warning : lost a text position. (HilightMaker)");
				break;//error?
			}

			//update tree
			tempList.clear();
			int slideLength = res.end;//slide length
			Iterator it2 = keywordTree.iterator();
			while(it2.hasNext()) {
				Keyword key = (Keyword)it2.next();
				if (key.ps < slideLength || res == key) {
					it2.remove();
					if (search(perl5Util,text,key)) {
						tempList.add(key);//next match
					}
					continue;
				}
				key.ps -= slideLength;
				key.end -= slideLength;
			}
			keywordTree.addAll(tempList);//merge with tree
		}
		list.add(new CharBlock(text));
	}

	/** 
		@param util Perl5Util
		@param text source text
		@param keywordInfo keyword info set
	*/
	protected boolean search(Perl5Util util,String text,Keyword keywordInfo) {
		if (keywordInfo.regexSwitch) {
			return searchByRegex(util,text,keywordInfo);
		} else {
			return searchByIndex(text,keywordInfo);
		}
	}

	private boolean searchByIndex(String text,Keyword keywordInfo) {
		try {
			int length = keywordInfo.keyword.length();
			int curPs = -length;
			while (true) {
				curPs = text.indexOf(keywordInfo.keyword,curPs+length);
				if (curPs == -1) return false;
				if (curPs > 0 && 
					Character.isJavaIdentifierPart(text.charAt(curPs-1))) 
					continue;
				if (curPs < (text.length()-1) && Character.isJavaIdentifierPart(text.charAt(curPs + length)))
					continue;
				break;
			}
			keywordInfo.ps = curPs;
			keywordInfo.end = curPs + length;
			keywordInfo.matchedWord = keywordInfo.keyword;
			return true;
		} catch (RuntimeException e) {
			System.err.println("E:"+keywordInfo.keyword+"  ("+
							   keywordInfo.matchedWord+")");
			e.printStackTrace();
		}
		return false;
	}

	private boolean searchByRegex(Perl5Util perl5Util,String text,
								  Keyword keywordInfo) {
		try {
			if (perl5Util.match("#" + keywordInfo.keyword + "#m", text)) {
				keywordInfo.matchedWord = perl5Util.toString();
				MatchResult mr = perl5Util.getMatch();
				keywordInfo.ps = mr.beginOffset(0);
				keywordInfo.end = mr.endOffset(0);
				return true;
			}
		} catch (RuntimeException e) {
			System.err.println("E:"+keywordInfo.keyword+"  ("+
							   keywordInfo.matchedWord+")");
			e.printStackTrace();
		}
		return false;
	}


	private class Keyword implements Comparable {
	
		private int ps=-1; //matched start position
		private int end=-1;//matched end position
		private boolean regexSwitch = false;//if use regex to search the word, true
		private String keyClass=null;//keyword class
		private String keyCSSClass=null;//keyword css class
		private String keyword=null;//keyword string
		private String matchedWord=null;//matched string
	
		private Keyword(String s,boolean m,String t) {
			regexSwitch = m; keyword = s;
			int index = t.indexOf("#");
			if (index == -1) {
				keyClass = t;
			} else {
				keyClass = t.substring(0, index);
				keyCSSClass = t.substring(index + 1);
			}
		}

		private Keyword(String s,boolean m,String t,String c) {
			regexSwitch = m; 
			keyword = s;
			keyClass = t;
			keyCSSClass = c;
		}
		
		private Content getContent() {
			try {
				if (keyword != null) {
					Container ct = 
						(Container)(Class.forName(keyClass).newInstance());
					if (keyCSSClass != null) {
						ct.setClazz(keyCSSClass);
					}
					ct.addContent(new CharBlock(matchedWord));
					return ct;
				}
			} catch(Exception e) {
				throw new RuntimeException("Class "+keyClass+" not found.");
			}
			return new CharBlock(matchedWord);
		}
	
		public int compareTo(Object o) {
			if (o instanceof Keyword) {
				Keyword t = (Keyword)o;
				return ps - t.ps;
			}
			throw new InternalError();
		}
	
	}
}
