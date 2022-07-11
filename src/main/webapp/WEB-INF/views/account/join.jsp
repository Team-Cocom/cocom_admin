<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<script src="/assets/js/account/join.js"></script>
</head>
<body>
    <main>
        <div class="join_area">
            <p>아이디</p>
            <input type="text" id="aa_id">
            <p>비밀번호</p>
            <input type="password" id="aa_pwd">
            <p>관리자 유형</p>
            <select id="aa_role">
                <option value="1">관리자</option>
                <option value="2">슈퍼 관리자</option>
            </select>
            <button id="join">등록</button>
        </div>
    </main>
</body>
</html>