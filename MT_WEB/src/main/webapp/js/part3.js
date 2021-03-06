var theRequest;
var str;
var url;
var startpage = 1;
var totalpage = 1;
var pagerlist = document.getElementById("pagerlist");

function GetRequest() {
	url = location.search; //获取url中"?"符后的字串
	theRequest = new Object();
	if (url.indexOf("?") != -1) {
		str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[decodeURIComponent(strs[i].split("=")[0])] = unescape(decodeURIComponent(strs[i].split("=")[1]));
		}
	}
	if(theRequest['filter']!=undefined && theRequest['filter'] != "") {document.getElementById("filter"+theRequest['filter']).classList.add("filterselected");}
	if(theRequest['sorter']!=undefined && theRequest['sorter'] != "") {document.getElementById("sorter"+theRequest['sorter']).classList.add("filterselected");}
	pagerdecider();
	return theRequest;
}

function pagerdecider() {
    if(theRequest['start']!=undefined && theRequest['start'] != 20) {
        startpage = theRequest['start'] / 20;
        if(startpage >= 5) {
            for(var i = 1; i <= 5; i++) {
                document.getElementById("pager"+i).innerHTML=
                    "<a href=\"javascript:void(0);\" onclick=\"pager("+i+")\">"+(startpage + i - 3)+"</a>";
            }
            document.getElementById("pager3").classList.add("active");
            document.getElementById("pager3").innerHTML=
                "<span>"+(startpage)+"</span>";
            document.getElementById("firstpage").style.display="inline";
            document.getElementById("ellipsis").style.display="inline";
        }
        else {
            document.getElementById("pager"+startpage).classList.add("active");
            document.getElementById("pager"+startpage).innerHTML=
                "<span>"+startpage+"</span>";
        }
    } else {
        document.getElementById("pager1").classList.add("active");
        document.getElementById("pager1").innerHTML=
            "<span>1</span>";
        document.getElementById("previous").className="disabled";
        document.getElementById("previous").innerHTML=
            "<span>&laquo;</span>";
    }
}

function filter(num) {
	url=url.replace(/start=[0-9]*/,"start=20");
	if(theRequest['filter'] == undefined) {
		window.location.href=location.pathname
							+url+"&filter="+num;
	}
	else if(theRequest['filter'] == num) {
		window.location.href=location.pathname
							+url.replace(/&filter=[0-9]*/,"");
	}
	else {
		window.location.href=location.pathname
							+url.replace(/&filter=[0-9]*/,"&filter="+num);
	}
}
function sorter(num) {
	url=url.replace(/start=[0-9]*/,"start=20");
	if(theRequest['sorter'] == undefined) {
		window.location.href=location.pathname
							+url+"&sorter="+num;
	}
	else if(theRequest['sorter'] == num){
		window.location.href=location.pathname
							+url.replace(/&sorter=[0-9]*/,"");
	} 
	else {
		window.location.href=location.pathname
							+url.replace(/&sorter=[0-9]*/,"&sorter="+num);
	}
}
function pager(num) {
    var res;
    if(num == -1) {res = (startpage - 1) * 20;}
    else if(num == 0) {res = (startpage + 1) * 20;}
    else if(num == -10) {res = 20;}
    else {
        res = document.getElementById("pager"+num).innerText * 20;
    }
    if(theRequest['start'] == undefined) {
        window.location.href=location+"&start="+res;
    }
    else {
        window.location.href=location.pathname
            +url.replace(/&start=[0-9]*/,"&start="+res);
    }
}
