<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>로그인</title>
    <style>
        .main {
            width: auto;
            height: 1100;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background-color: #F2F2F2;
        }
        .divMain{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        .mainHead {
            margin-top: 40px;
        }

        .bannderText {
            font-size: 70px;
            font-family: Nanum;
            justify-content: center;
            display: flex;
            color: #262120;
        }

        .text {
            margin-top: 30px;
            font-size: 17px;
        }

        .textInput {
            width: 370px;
            height: 40px;
            font-size: 30px;
        }

        .LoginBtn {
            width: 200px;
            height: 60px;
            margin-top: 50px;
        }

        .LoginBtnText {
            font-size: 25px;
        }
        a{
            text-decoration: none;
            color: black;
        }
    </style>
</head>

<body class="main">
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
        <div>
            <form>
                <div>
                    <h3 class="text">
                        <label>아이디</label>
                    </h3>
                    <input class="textInput" type="text" />
                </div>

                <div>
                    <h3 class="text">
                        <label>비밀번호</label>
                    </h3>
                    <input class="textInput" type="password" />
                </div>
            </form>
        </div>
        <div class="divMain">
            <button class="LoginBtn" type="button">
                <span class="LoginBtnText">비밀번호 찾기</span>
            </button>
        </div>
    </div>
</body>

</html>