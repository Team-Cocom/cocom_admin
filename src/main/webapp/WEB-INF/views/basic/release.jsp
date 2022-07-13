<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<script src="/assets/js/basic/release.js"></script>
</head>
<body>
    <main>
        <table>
            <thead>
                <tr>
                    <td>순번</td>
                    <td>발매사명</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.rci_name}</td>
                        <td>
                            <button class="delete" data-seq="${item.rci_seq}">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
                <input type="text" id="rci_name" placeholder="발매사 회사명을 입력해주세요.">
            </tbody>
        </table>
        <button id="add_save">등록</button>
        <button id="add_cancel">취소</button>
        <div class="pager_area">
            <c:forEach begin="1" end="${pageCnt}" var="i">
                <a href="/release/list?page=${i}&keyword=${keyword}">${i}</a>
            </c:forEach>
        </div>
    </main>
</body>
</html>