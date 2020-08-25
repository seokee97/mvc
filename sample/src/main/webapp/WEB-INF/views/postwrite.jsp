<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>main</title>
<link rel="stylesheet" href="resources/css/postwrite.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<script>
	function btn_find_post(){
			$.ajax({
			url:"/loginchk",
			type:"post",
			datatype:"json",
			data:idval,
			success:function(a){
			}
			});
	}

function btn_writepost(){
	var title = document.getElementById("postName").value;
	var text = document.getElementById("postText").value;
	
	if(title == "" || text == ""){
		alert("다 채워주세요");
		return;
	}
	document.writepost.action="/postwritesql";
	document.writepost.submit();
}



</script>
<body>
	<form name="login" id="login" method="post">
		<div class="div_top_view">
			<a href="/" class="a_top_view"><h3>홈</h3></a>
			<!-- <a href="login" class="a_top_view"><h3>로그인</h3></a> -->
			<script>
				function logout(){
					document.login.action="/logout";
					document.login.submit();
				}
				var value = "${userinfo}"
					if(value == ""){
						document.write('<a href="login" class="a_top_view"><h3>로그인</h3></a>');
					}else{
						document.write('<button type="button" class="btn_login_logout" onclick = "logout();">로그아웃</button>');
						//document.write('<a id = "btn_logout" href="#" onclick = "window.location.href='/logout'" class="a_top_view"><h3>로그아웃</h3></a>');
					}
		</script>

		</div>
		</form>
		<div class="div_banner_view">
			<img class="img_banner" src="resources/img/banner.jpg">
			<h1 class="h1_banner">Seokee</h1>
		</div>
		<div class="div_body">
			<div>
				<form id = "writepost" action = "" name="writepost" method="POST">
					<div class="div_title">
						<span>제목</span>
						<input id = "postName" name = "postName" type = "text" value = "">
					</div>
					<div>
						<textarea id = "postText" name = "postText" class="textarea_writepost" cols="50" rows="150"
							name="text"></textarea>
					</div>
					
					<button type="button" onclick="btn_writepost();">글쓰기</button>

				</form>
			</div>

		</div>
	

</body>

</html>