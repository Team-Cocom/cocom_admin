<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<script src="/assets/js/basic/enter.js"></script>
<link rel="stylesheet" href="/assets/css/basic/enter.css">
</head>
<body>
    <main>
        <div class="enter_list_wrap">
        <button id="enter_add_btn">엔터회사 추가</button>
            <table class="enter_list_area">
                <h1>엔터회사 리스트</h1>
                <div class="enter_list">
                <thead class="enter_title">
                    <tr>
                        <td>No</td>
                        <td>엔터명</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="item" varStatus="stat">
                        <tr class="enter_detail_info">
                            <td>${stat.count}</td>
                            <td>${item.ent_name}</td>
                            <td>
                                <button class="delete" data-seq="${item.ent_seq}">삭제</button>
                            </td>
                        </tr>
                    </c:forEach>
                    <div class="enter_add_area">
                        <button id="add_save">등록</button>
                        <button id="add_cancel">취소</button>
                        <input type="text" id="ent_name" placeholder="엔터 회사명을 입력해주세요.">
                    </div>
                </tbody>
                </div>
            </table>
            <div class="pager_area">
                <c:forEach begin="1" end="${pageCnt}" var="i">
                    <a href="/enter/list?page=${i}&keyword=${keyword}">${i}</a>
                </c:forEach>
            </div>
        </div>
    </main>
</body>
</html>