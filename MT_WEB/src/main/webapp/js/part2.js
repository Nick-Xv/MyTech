var advhref = "/MyTech/search2?title=&author=&keyword=&date1=&date2=&mode=true";

function advsearchtype(num) {
	if(num == 1) {
		document.getElementById("btn").disabled=false;
		advhref="/MyTech/search2?title=&author=&keyword=&date1=&date2=&mode=true";
		document.getElementById("form1").action="/MyTech/search2";
	}
	else if (num == 2) {
		document.getElementById("btn").disabled=false;
		advhref="/MyTech/search3?title=&author=&keyword=&date1=&date2=&mode=true";
		document.getElementById("form1").action="/MyTech/search3";
	}
	else if(num == 3) {
		document.getElementById("btn").disabled=true;
		document.getElementById("form1").action="/MyTech/search4";
	}
}

function advsearch() {
	window.location.href=advhref;
}