<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="resources/css/signup.css">
<script type="text/javascript">
		var idchk = "";
	</script>
</head>

<body class="bodyMain">
	<!-- main -->
	<div>
		<!-- 배너 -->
		<div class="mainHead">
			<h1>
				<a class="bannderText" href="/">Seokee</a>
			</h1>
		</div>
		<!-- 회원가입 구성요소 -->
		<!-- 아이디, 비밀번호 -->
		<div>
			<form name="signup" method="POST">
				<div>
					<h3 class="text">
						<label>아이디</label>
					</h3>
					<input id="id" class="textInput" type="text" name="id" value="" />
					<input id="idcheckBtn" type="button" class="idcheckBtn"
						value="중복체크" onclick="javascript:idcheck();" />

				</div>

				<div>
					<h3 class="text">
						<label>비밀번호</label>
					</h3>
					<input id="pw" class="textInput" type="password" name="password" />
				</div>
				<div>
					<h3 class="text">
						<label>비밀번호 재확인</label>
					</h3>
					<input id="pwch" name="passwordcheck" class="textInput"
						type="password" />

				</div>

				<div>
					<h3 class="text">
						<label>이름</label>
					</h3>
					<input id="name" class="textInput" type="text" name="name" />
				</div>

				<div>
					<h3 class="text">
						<label>성별</label>
					</h3>
					<select id="gender" class="genderBox" name="gender">
						<option>성별</option>
						<option>남자</option>
						<option>여자</option>
					</select>
				</div>
			</form>
		</div>
		<div class="divMain">
			<button class="singupBtn" type="button" onclick="insertTest();">
				<span>가입하기</span>
			</button>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</body>
<script>
function insertTest(){
	var id = document.getElementById("id").value;
	var pw = document.getElementById("pw").value;
	var pwch = document.getElementById("pwch").value;
	var gender = document.getElementById("gender").value;
	var name = document.getElementById("name").value;
	
	if(id == "" || pw == ""|| pwch == ""|| gender == "성별"|| name == ""){
		alert("다 채워주세요");
		return;
	}else if(idchk == ""){
		alert("중복확인을 해주세요");
		return;
	}else{
	console.log(pw);
		console.log(pwch);
		if(pw != pwch){
			alert("비밀번호 확인");
			return;
		}
	}
	document.signup.action="/signupinsert";
	document.signup.submit();
}

function idcheck(){
	var id = document.getElementById("id").value;
	var idval = "id="+document.getElementById("id").value;
	if(id == ""){
		alert("아이디를 입력하세요");
	} else{		
		$.ajax({
			url:"/loginchk",
			type:"post",
			datatype:"json",
			data:idval,
			success:function(a){
				if(a >= 1){
					alert("사용중인 id입니다.");
					document.getElementById("id").value ="";
					idchk = "";
				}else{
				alert("사용가능합니다.");
				document.getElementById("id").value = id;
				idchk = id;
				}
			}
			});
	}
				
}
</script>
</html>