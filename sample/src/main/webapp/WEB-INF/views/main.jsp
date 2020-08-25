<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>main</title>
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<script>
		function btn_postwrite(){
		var id = "${userinfo}";
		if(id == ""){
			alert("로그인후 이용해주세요");
			return;
		}
		document.postwrite.action="/postwrite";
		document.postwrite.submit();
		}
</script>
<body>
	<form name="login" id="login" method="post">
		<div class="div_top_view">
			<a href="/" class="a_top_view"><h3>홈</h3></a>
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
					}
					
		</script>
	</form>
	</div>
	<div class="div_banner_view">
		<img class="img_banner" src="resources/img/banner.jpg">
		<h1 class="h1_banner">Seokee</h1>
	</div>

	<div class="div_body">

		<div class="div_btn_write">
			<form name="postwrite" id="postwrite" method="POST">
				<input type="button" id="btn_write" onClick="btn_postwrite();"
					value="글쓰기" />
			</form>
		</div>


		<div class="div_find_post">

			<form name="find_post" id="find_post" action="/findpost">
				<select class="select_find_post" name="find_subject">
					<option>Title</option>
					<option>postID</option>
				</select> <input id="input_find_post" class="input_find_post" type="text"
					name="input_find" /> <input type="submit" class="btn_find_post"
					id="btn_find_post" onclick="window.location.href='/findpost'"
					value="Select" />
			</form>
		</div>
		<script>
				
			</script>
		<div class="div_table">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">NO.</th>
						<th scope="col">Title</th>
						<th scope="col">postID</th>
						<th scope="col">Date</th>
					</tr>
				</thead>

				<tbody>
					<c:set var="findpost" value="${findPost_OK}" />
					

						<c:if test="${findpost eq null }">
							<c:forEach var="list" items="${postList}" varStatus="status">
							<form name="show_post" id="show_post" action="showpost">
								<script>
									var postNumValue = ${list.postNum };
									document.write("<input type='hidden' name ='postNum' value = "+postNumValue+" />");
								</script>
								<tr>
									<th scope="row">${list.postNum }</th>
									<td><input id="postName" name="postName" type="submit"
										onclick="window.location.href='/showpost'"
										value="${list.postName}" /></td>
									<td>${list.postId}</td>
									<td>${list.postDate}</td>
								</tr>
								</form>
							</c:forEach>
						</c:if>
					

					<%-- 					<c:set var="findpost" value="${findPost_OK}" /> --%>
					
						<c:if test="${findpost eq 'findPost_OK' }">
							<c:forEach var="findlist" items="${findPostList}"
								varStatus="status">
								<form name="show_post" id="show_post" action="showpost">
								<script>
									var postNumValue = ${findlist.postNum };
									document.write("<input type='hidden' name ='postNum' value = "+postNumValue+" />");
								</script>
								<tr>
									<th scope="row">${findlist.postNum }</th>
									<td><input id="postName" name="postName" type="submit"
										onclick="window.location.href='/showpost'"
										value="${findlist.postName}" /></td>
									<td>${findlist.postId}</td>
									<td>${findlist.postDate}</td>
								</tr>
								</form>
							</c:forEach>
						</c:if>
					
				</tbody>
			</table>
			<div class="div_page">
				<script>
				var inputValue = "${inputfind}";
				var maxPage = ${maxPage};
					for(var i = 0; i<maxPage;i++){
						document.write("<form name = 'paging' id= 'paging' action='paging'>");
							document.write("<input id = 'now_Page' name = 'now_Page' type='submit' value = "+(i+1)+">");
							if(inputValue == ""){
								document.write("<input name = 'input_find' type='hidden' value = inputValue>");
							}
						document.write("</form>");
					}
				</script>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>

</html>