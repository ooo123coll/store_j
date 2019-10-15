function clearString(str){ 
    var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）&;|{}【】‘；：”“'。，、？]") 
    var s = ""; 
    for (var i = 0; i < str.length; i++) { 
        s += str.substr(i, 1).replace(pattern, ''); 
    } 
    return s;  
} 

function htmlencoded(str){
	var s = "";
    if (str.length == 0) return "";
    s = str.replace(/ /g, "&nbsp;");
    s = str.replace(/&/g, "&amp;");
    s = str.replace(/</g, "&lt;");
    s = s.replace(/%3C/g,"&lt;");
    s = s.replace(/%3c/g,"&lt;");
    s = s.replace(/>/g, "&gt;");
    s = s.replace(/%3E/g, "&gt;");
    s = s.replace(/%3e/g, "&gt;");
    s = s.replace(/%26lt%3B/g, "&lt;");
    s = s.replace(/%26lt%3b/g, "&lt;");
    s = s.replace(/%26gt%3B/g, "&gt;");
    s = s.replace(/%26gt%3b/g, "&gt;");
    s = s.replace(/\'/g, "&#39;");
    s = s.replace(/\"/g, "&quot;");
    s = s.replace(/\n/g, "<br>");
    return s;
}