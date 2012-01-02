package org.relaxer.framework.runtime.models.html;

import com.AsamiOffice.util.D2Array;

/**
 * HtmlTable
 *
 * @since   Sep.  7, 2005
 * @version Sep.  7, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class HtmlTable {
    private D2Array head_ = null;
    private D2Array foot_ = null;
    private D2Array body_ = new D2Array();
    private int x_;
    private int y_;
    private StringBuffer buffer_;
    private D2Array current_;
    
    public HtmlTable() {
        enterBody();
    }

    public void enterHead() {
        y_ = -1;
        head_ = new D2Array();
        current_ = head_;
    }

    public void enterFoot() {
        y_ = -1;
        foot_ = new D2Array();
        current_ = foot_;
    }

    public void enterBody() {
        y_ = -1;
        current_ = body_;
    }

    public void enterRecord() {
        x_ = 0;
        y_++;
    }

    public void enterHeader() {
        enterData();
    }

    public void enterData() {
        buffer_ = new StringBuffer();
    }

    public void leaveHead() {
    }

    public void leaveFoot() {
    }

    public void leaveBody() {
    }

    public void leaveRecord() {
    }

    public void leaveHeader() {
        leaveData();
    }

    public void leaveData() {
        current_.put(x_, y_, buffer_.toString());
        buffer_ = null;
        x_++;
    }

    public void addText(char[] ch, int start, int length) {
        if (buffer_ != null) {
            buffer_.append(ch, start, length);
        }
    }

    public void end() {
    }

    public int getWidth() {
        return body_.getWidth();
    }

    public int getHeight() {
        return body_.getHeight();
    }

    public String get(int x, int y) {
        return (String)body_.get(x, y);
    }
}