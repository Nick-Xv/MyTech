var watch=document.getElementById("watch");
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
    alert(id1);
    alert(id2);
	$.ajax({
	    url:"/MyTech/professor/watch?id1="+id1+"&id2="+id2,
	    type:'get',
	    dataType:'text',
	    success:function(data){
	        if(watch.value=="false"){
	        	watch.className="btntrue";
	        	watch.innerHTML="已关注"
	        } else if(watch.value=="true") {
	        	watch.className="btnfalse";
	        	watch.innerHTML="关注"
	        }
	    },
	    error:function (data) {
	        alert("炸了");
	    }
	});
}

function purchase(id1, id2) {
	alert(id1);
    alert(id2);
	$.ajax({
	    url:"/MyTech/essay/purchase?id1="+id1+"&id2="+id2,
	    type:'get',
	    dataType:'text',
	    success:function(data){
			if(data == "true") {
				if(confirm("确认购买吗?")==true) {
					$.ajax({
					    url:"/MyTech/essay/confirm?id1="+id1+"&id2="+id2,
					    type:'get',
					    dataType:'text',
					    success:function(data){
					        document.getElementById("link").innerHTML=
							"<a href=\""+data+"\">下载</a>";
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