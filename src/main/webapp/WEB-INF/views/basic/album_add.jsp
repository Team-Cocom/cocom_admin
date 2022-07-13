<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <div class="basic_info">
        <h1>앨범 정보 추가</h1>
        <table class="album_info">
            <tbody>
                <tr>
                </tr>
            </tbody>
        </table>
    </div>
    <button id="ab_add_save">추가</button>
    <button id="ab_add_cancel">취소</button>
</div>
<div class="pager_area">
    <c:forEach begin="1" end="${pageCnt}" var="i">
        <a href="/album/add?page=${i}&keyword=${keyword}">${i}</a>
    </c:forEach>
</div>
</body>
</html