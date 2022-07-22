<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Document</title>
        <link rel="stylesheet" href="/assets/css/reset.css">
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="/assets/js/common/util.js"></script>
        <script src="/assets/js/index.js"></script>
        <link rel="stylesheet" href="/assets/css/index.css">
</head>
<body>
    <main>
        <div class="login_box">
            <div class="login_box_wrap">
                <div class="login_box_area">
            <h1>Admin login</h1>
                <input type="text" id="aa_id" placeholder="아이디를 입력해주세요">
                <input type="password" id="aa_pwd" placeholder="비밀번호를 입력해주세요">
                <p>
                    <button id="login_btn">로그인</button>
                </p>
            <a href="/account/join">관리자추가</a>
        </div>
        </div>
        </div>
    </main>
</body>
</html>