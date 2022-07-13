<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Document</title>
        <link rel="stylesheet" href="/assets/css/reset.css">
        <script src="/assets/js/common/util.js"></script>
        <script src="/assets/js/index.js"></script>
</head>
<body>
    <main>
        <div class="login_box">
            <h1>Admin login</h1>
                <p class="label">아이디</p>
                <input type="text" id="aa_id">
                <p class="error">아이디를 올바르게 입력하세요.</p>
                <p class="label">비밀번호</p>
                <input type="password" id="aa_pwd">
                <p class="error">비밀번호를 올바르게 입력하세요.</p>
            <button id="login_btn">로그인</button>
        </div>
    </main>
</body>
</html>