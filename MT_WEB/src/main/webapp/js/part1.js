var theRequest;
var str;
var url;
var title = document.getElementById('title');
var author = document.getElementById('author');
var keyword = document.getElementById('keyword');
var date1 = document.getElementById('date1');
var date2 = document.getElementById('date2');
var mode = document.getElementById("mode");
var advsearch = document.getElementById("advsearch");
var startpage = 1;

function GetRequest() {
	url = location.search; //获取url中"?"符后的字串
	theRequest = new Object();
	if (url.indexOf("?") != -1) {
		document.getElementById('fil-sor').hidden=false;
		str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[decodeURIComponent(strs[i].split("=")[0])] = unescape(decodeURIComponent(strs[i].split("=")[1]));
		}
	}

	if(title) {title.value=theRequest['title'];}
	if(author) {author.value=(theRequest['author']=="undefined" || theRequest['author'] == null)?"":theRequest['author'];}
	if(keyword) {keyword.value=(theRequest['keyword']=="undefined" || theRequest['keyword'] == null)?"":theRequest['keyword'];}
	if(date1) {date1.value=theRequest['date1'];}
	if(date2) {date2.value=theRequest['date2'];}
	if(theRequest['mode']=="true") {
		//alert("aaa");
		if(advsearch) {advsearch.className="collapse in";}
		if(mode) {mode.value="true";}
	}
	if(theRequest['filter']!=undefined && theRequest['filter'] != "") {document.getElementById("filter"+theRequest['filter']).classList.add("filterselected");}
	if(theRequest['sorter']!=undefined && theRequest['sorter'] != "") {document.getElementById("sorter"+theRequest['sorter']).classList.add("filterselected");}
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
	return theRequest;
}
function aaa() {
	//alert(document.getElementById("titlelabel").style.width);
	if(document.getElementById("advsearch").className=='collapse') {
		if(mode) {mode.value="true";}
	}
	else {
		if(mode) {mode.value="false";}
	}
}
function filter(num) {
	if(theRequest['filter'] == undefined) {
		window.location.href=location+"&filter="+num;
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
	if(theRequest['sorter'] == undefined) {
		window.location.href=location+"&sorter="+num;
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
