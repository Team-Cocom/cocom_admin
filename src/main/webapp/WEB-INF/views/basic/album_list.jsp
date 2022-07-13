<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/basic/album_detail.js"></script>
</head>
<body>
    <h1>앨범정보에오</h1>
    <button id="album_popup_btn">
        <a href="/albums/add">앨범 정보 추가</a>
    </button>
    <div class="basic_info">
        <h1>앨범 기본 정보</h1>
        <table class="album_info">
            <thead>
                <tr>
                    <td>앨범명</td>
                    <td>가수</td>
                    <td>소속사</td>
                    <td>발매사</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item" varStatus="stat">
                    <tr>
                        <td></td>
                        <td>
                            <button class="del_btn" data-seq="${item.ab_seq}">삭제</button>
                        </td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pager_area">
        <c:forEach begin="1" end="${pageCnt}" var="i">
            <a href="/album/list?page=${i}&keyword=${keyword}">${i}</a>
        </c:forEach>
    </div>
</body>
</html>