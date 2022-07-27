<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<script src="/assets/js/basic/release.js"></script>
<link rel="stylesheet" href="/assets/css/basic/release.css">
</head>
<body>
    <main>
        <div class="release_list_wrap">
            <button class="release_add_btn">발매사 추가하기</button>
            <table class="relese_list_area">
                <h1>발매사 리스트</h1>
                <div class="release_list">
                    <thead class="release_title">
                        <tr>
                            <td>No</td>
                            <td>발매사명</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${releaseList}" var="item" varStatus="stat">
                            <tr class="release_detail_info">
                                <td>${stat.count}</td>
                                <td>${item.rci_name}</td>
                                <td>
                                    <button class="delete" data-seq="${item.rci_seq}">삭제</button>
                                </td>
                                <td></td>
                            </tr>
                        </c:forEach>
                        <div class="release_add_area">
                            <input type="text" id="rci_name" placeholder="발매사 회사명을 입력해주세요.">
                            <button id="add_save">등록</button>
                            <button id="add_cancel">취소</button>
                        </div>
                    </tbody>
                </div>
            </table>
            <div class="pager_area">
                <c:forEach begin="1" end="${pageCnt}" var="i">
                    <a href="/release/list?page=${i}&keyword=${keyword}">${i}</a>
                </c:forEach>
            </div>
        </div>  
    </main>
</body>
</html>