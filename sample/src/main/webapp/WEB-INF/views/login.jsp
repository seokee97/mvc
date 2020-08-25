<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="resources/css/login.css">
    
</head>
<script>

</script>
<body class="bodyMain">
    <!-- main -->
    <div>
        <!-- 배너 -->
        <div class="mainHead">
            <h1>
                <a class="bannderText" href="/">Seokee</a>
            </h1>
        </div>
        <!-- 로그인 구성요소 -->
        <!-- 아이디, 비밀번호 -->
        <form name="login" method="post" action="/loginBtn">
        <div>
                <div>
                    <h3 class="text">
                        <label>아이디</label>
                    </h3>
                    <input class="textInput" name="id" type="text" />
                </div>

                <div>
                    <h3 class="text">
                        <label>비밀번호</label>
                    </h3>
                    <input class="textInput" name="password" type="password" />
                </div>
        </div>
        <div class="divMain">
            <button class="LoginBtn" type="submit">
                <span class="LoginBtnText">로그인</span>
            </button>
        </div>
		</form>
        <div class="line">
            <hr size="3" color="#F2F2F2" width="370px">
        </div>

        <div class="divMain2">
            <a href="findpw">ID / PW 찾기</a>
            <span class="signUpMargin">│</span>
            <a href="signup">회원가입</a>
        </div>
    </div>
</body>
</html>