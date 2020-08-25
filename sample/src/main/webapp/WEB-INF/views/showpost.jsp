<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>main</title>
<link rel="stylesheet" href="resources/css/showpost.css">
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
		<script>
			if("${userId}" == "${postInfo.postId}"){
			document.write("<div>");
				document.write("<form name ='deletePost' method='post' action='/deletePost'>");
					document.write("<input type ='hidden' name='postNum' value = ${postInfo.postNum}>");
					document.write("<input type ='hidden' name='postId' value = ${postInfo.postId}>");
					document.write("<input type ='hidden' name='postName' value = ${postInfo.postName}>");
					document.write("<button type = 'submit' class='btn_delete' >삭제</button>");
				document.write("</form>");
			document.write("</div>");
			}
		</script>
		<div class="div_body">
			<div>
					<div class="div_title">
						<span>제목 : ${postInfo.postName}</span>
					</div>
					
					<div>
						<span>글쓴이 : ${postInfo.postId }</span>
					</div>
					
					<div>
						<span>${postInfo.postText }</span>
					</div>

			</div>
			
			<div class = "div_comment">
				<form name ="comment" method="post" action="/comment">
					<input  name = "postComment" class = "comment_text" type ="text"></input>
					<button type = "submit" class="btn_comment">댓글</button>
				</form>
			</div>

		</div>
	

</body>
</html>