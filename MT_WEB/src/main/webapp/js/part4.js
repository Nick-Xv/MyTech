var watch=document.getElementById("watch");
var essaytype=document.getElementById("essaytype");
var link=document.getElementById("link");

function checkEssayType() {
	if(essaytype.innerHTML == "1") {
		link.classList.remove("btnjump");
		link.classList.add("btnpurchase");
		link.innerHTML="购买论文";
	} else if (essaytype.innerHTML == "2") {
		link.classList.remove("btnjump");
		link.classList.add("btndownload");
		link.innerHTML="下载论文";
	}
}

function checkwatch() {
	if(watch.value=="true"){
		watch.className="btntrue";
		watch.innerHTML="已关注"
	} else if(watch.value=="false") {
		watch.className="btnfalse";
		watch.innerHTML="关注"
	}
}
function watch1(id1, id2) {
    if(id1=="null"){
    	// alert("!!!");
    	window.location.href="/MyTech/to_login";
	}
	else if(id2=="null"){
		return;
	}
	else{
        // alert("???");
        $.ajax({
            url:"/MyTech/professor/watch?id1="+id1+"&id2="+id2,
            type:'get',
            dataType:'text',
            success:function(data){
                if(watch.value=="false"){
                    watch.className="btntrue";
                    watch.value = "true";
                    watch.innerHTML="已关注"
                } else if(watch.value=="true") {
                    watch.className="btnfalse";
                    watch.value = "false";
                    watch.innerHTML="关注"
                }
            },
            error:function (data) {
                alert("炸了");
            }
        });
	}
}

function purchase(id1, id2) {
    if(id1 == "null"){
    	window.location.href("/MyTech/to_login");
    	return;
	}
	$.ajax({
	    url:"/MyTech/essay/purchase?id1="+id1+"&id2="+id2,
	    type:'get',
	    dataType:'text',
	    success:function(data){
			data = JSON.parse(data);
			if(data.result == "true") {
				if(confirm("当前论文价格为："+data.price+"\n确认购买吗?")==true) {
					$.ajax({
					    url:"/MyTech/essay/confirm?id1="+id1+"&id2="+id2,
					    type:'get',
					    dataType:'text',
					    success:function(data){
					        link.href=data;
							link.classList.remove("btnjump");
							link.classList.add("btndownload");
					    },
					    error:function (data) {
					        alert("炸了");
					    }
					});
				}
			}
			else{
				alert("余额不足，请充值");
			}
	    },
	    error:function (data) {
	        alert("炸了");
	    }
	});
}