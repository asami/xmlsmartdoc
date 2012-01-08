/*
 * HTML4JavaScript.js
 *
 * @since   Nov. 17, 1998
 * @version Feb. 18, 2002
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
var backupColor=null;
var backupBGColor=null;
var backupFontStyle=null;
var backupIDColor=null;
var backupIDBGColor=null;
var backupIDFontStyle=null;
var backupIDBorderStyle=null;

var backupOnKeyDown=null;

function normal(element) {
  if (document.all) {
    if (backupColor != null) {
      element.style.color=backupColor;
      backupColor=null;
    }
    if (backupBGColor != null) {
      element.style.background=backupBGColor;
      backupBGColor=null;
    }
    if (backupFontStyle != null) {
      element.style.fontStyle=backupFontStyle;
      backupFontStyle=null;
    }
    var id = null;
    if (element.href != null) {
      id = element.href;
      id = id.substring(id.indexOf("#") + 1);
    }
    if (id != null) {
      var target = document.all.item(id, 0);
      if (backupIDColor != null) {
        target.style.color=backupIDColor;
        backupIDColor=null;
      }
      if (backupIDBGColor != null) {
        target.style.background=backupIDBGColor;
        backupIDBGColor=null;
      }
      if (backupIDFontStyle != null) {
        target.style.fontStyle=backupIDFontStyle;
        backupIDFontStyle=null;
      }
      if (backupIDBorderStyle != null) {
        target.style.borderStyle=backupIDBorderStyle;
        backupIDBorderStyle=null;
      }
    }
  }
}

function hilight(element) {
  if (document.all) {
    backupBGColor=element.style.background;
    element.style.background="gold";
  }
}

function hilightString(element, color) {
  if (color == null) {
    color="darkolivegreen";
  }
  if (document.all) {
    backupColor=element.style.color;
    backupFontStyle=element.style.fontStyle;
    element.style.color=color;
  }
}

function hilightSelflink(element, color) {
  if (color == null) {
    color="darkolivegreen";
  }
  if (document.all) {
    backupColor=element.style.color;
    backupBGColor=element.style.background;
    backupFontStyle=element.style.fontStyle;
    element.style.color=color;
    var id = null;
    if (element.href != null) {
      id = element.href;
      id = id.substring(id.indexOf("#") + 1);
    }
    if (id != null) {
      var target = document.all.item(id, 0);
      backupIDColor=target.style.color;
//      backupIDBGColor=target.style.background;
//      backupIDFontStyle=target.style.fontStyle;
      backupIDBorderStyle=target.style.borderStyle;
      target.style.color="red";
      target.style.borderStyle="outset";
    }
  }
}

function hilightHyperlink(element, color) {
  if (color == null) {
    color="darkorange";
  }
  if (document.all) {
    backupColor=element.style.color;
    backupBGColor=element.style.background;
    backupFontStyle=element.style.fontStyle;
    element.style.color=color;
  }
}

function hilightExternallink(element, color) {
  if (color == null) {
    color="purple";
  }
  if (document.all) {
    backupColor=element.style.color;
    backupBGColor=element.style.background;
    backupFontStyle=element.style.fontStyle;
    element.style.color=color;
  }
}

function toggleChildren(node) {
  if (document.all) {
    for (i = 0;i < node.children.length;i++) {
      var child = node.children[i];
      if (child.className == "dynamic") {
        if (child.style.display == "") {
            child.style.display = "none";
        } else {
            child.style.display = "";
        }
      }
    }
  }
}

function toggleDynamic(node) {
  if (document.all) {
    if (node.tagName == "LI") {
      toggleChildren(node);
    }
  }
}

function isMsie4orGreater() { 
  var ua = window.navigator.userAgent; var msie = ua.indexOf ("MSIE");
  if (msie > 0) {
    return (parseInt (ua.substring (msie+5, ua.indexOf (".", msie))) >= 4)   
      && (ua.indexOf ("MSIE 4.0b") <0);
  } else {
    return false;
  }
}

function keyEventHandler() {
  if (document.all) {
    if (event.keyCode == 13) {
      var child = document.all.item("doc_next_page_", 0);
      if (child != null) {
        location.href = child.href;
      }
    } else if (event.keyCode == 39) {
      var child = document.all.item("doc_next_page_", 0);
      if (child != null) {
        location.href = child.href;
      }
    } else if (event.keyCode = 37) {
      var child = document.all.item("doc_prev_page_", 0);
      if (child != null) {
        location.href = child.href;
      }
    } else {
      backupOnKeyDown();
    }
  }
}

function setOHPHandler() {
  backupOnKeyDown=document.onkeydown;
  document.onkeydown=keyEventHandler;
}
