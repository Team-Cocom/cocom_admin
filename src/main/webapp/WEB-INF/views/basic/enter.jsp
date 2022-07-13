<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<script src="/assets/js/basic/enter.js"></script>
</head>
<body>
    <main>
        <table>
            <%-- <button id="add_popup_button">추가</button>
            <input type="text" id="add_popup_save" style="display:none"> --%>
            <thead>
                <tr>
                    <td>순번</td>
                    <td>엔터명</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.ent_name}</td>
                        <td>
                            <button class="delete" data-seq="${item.ent_seq}">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button id="add_save">등록</button>
        <button id="add_cancel">취소</button>
        <input type="text" id="ent_name">
        <div class="pager_area">
            <c:forEach begin="1" end="${pageCnt}" var="i">
                <a href="/enter/list?page=${i}&keyword=${keyword}">${i}</a>
            </c:forEach>
        </div>
    </main>
</body>
</html>