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
        <div class="page_header">
        </div>
        <button id="account_add">관리자 추가</button>
        <div class="content_area">
            <table>
                <thead>
                    <tr>
                        <td>순번</td><td>아이디</td><td>관리자명</td><td>권한등급</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="join_area">
            <p>아이디</p>
            <input type="text" id="aa_id">
            <p>비밀번호</p>
            <input type="password" id="aa_pwd">
            <p>이름</p>
            <input type="text" id="aa_name">
            <p>관리자 유형</p>
            <select id="aa_role">
                <option value="1">일반 관리자</option>
                <option value="2">슈퍼 관리자</option>
            </select>
            <button id="add">등록</button>
            <button id="add_cancel">취소</button>
        </div>
        <button id="delete">삭제</button>
    </main>
</body>
</html>