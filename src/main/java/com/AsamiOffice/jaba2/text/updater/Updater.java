/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AasamiOffice.com)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package com.AsamiOffice.jaba2.text.updater;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.AsamiOffice.jaba2.text.update.rRule.IRuleFactory;
import com.AsamiOffice.jaba2.text.update.rRule.Replace;
import com.AsamiOffice.jaba2.text.update.rRule.Rule;
import com.AsamiOffice.jaba2.text.update.rRule.RuleFactory;
import com.AsamiOffice.jaba2.text.update.rRule.RuleSet;
import com.AsamiOffice.jaba2.xml.IProcessor;
import com.AsamiOffice.jaba2.xml.ProcessorFactory;

import org.apache.oro.text.perl.Perl5Util;
import org.w3c.dom.Document;

import com.AsamiOffice.io.UURL;

/**
 * Updater
 *
 * @since   Nov.  9, 2000
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@AasamiOffice.com)
 */
public class Updater {
    private Perl5Util perl5_ = new Perl5Util();

    public String replace(String text, String uri)
        throws MalformedURLException, IOException {

        IProcessor processor = ProcessorFactory.getProcessor();
        URL url = UURL.getURLFromFileOrURLName(uri);
        Document doc = processor.parseDocument(url);
        IRuleFactory factory = RuleFactory.getFactory();
        RuleSet ruleSet = factory.createRuleSet(doc);
        return (replace(text, ruleSet));
    }

    public String replace(String text, RuleSet ruleSet) {
        if (!_needUpdate(text, ruleSet)) {
            return (text);
        }
        return (_update(text, ruleSet));
    }

    private boolean _needUpdate(String text, RuleSet ruleSet) {
        Rule[] rules = ruleSet.getRule();
        for (int i = 0;i < rules.length;i++) {
            if (_needUpdate(text, rules[i])) {
                return (true);
            }
        }
        return (false);
    }

    private boolean _needUpdate(String text, Rule rule) {
        String pattern = rule.getPattern();
        String regex = "/" + pattern + "/";
        return (perl5_.match(regex, text));
    }

    private String _update(String text, RuleSet ruleSet) {
        Rule[] rules = ruleSet.getRule();
        for (int i = 0;i < rules.length;i++) {
            text = _update(text, rules[i]);
        }
        return (text);
    }

    private String _update(String text, Rule rule) {
        String pattern = rule.getPattern();
        Replace replace = rule.getReplace();
        String regex = "s/" + pattern + "/" + replace.getContent() + "/mg";
        return (perl5_.substitute(regex, text));
    }
}
