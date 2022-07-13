<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/business/goods.js"></script>
</head>
<body>
    <h1>굿즈사이트에오</h1>
    <button id="goods_popup_btn">
        <a href="/goods/add">굿즈 추가</a>
    </button>
    <div class="basic_info">
        <h1>굿즈 기본 정보</h1>
        <table class="goods_info">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>제품명</td>
                    <td>가격</td>
                    <td>수량</td>
                    <td>재고</td>
                    <td>기획사정보</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${goodsList}" var="item" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.gz_name}</td>
                        <td>${item.gz_price}</td>
                        <td>${item.gz_count}</td>
                        <td>${item.gz_stock}</td>
                        <td>${item.ent_name}</td>
                        <td>
                            <button class="del_btn" data-seq="${item.gz_seq}">삭제</button>
                        </td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pager_area">
        <c:forEach begin="1" end="${pageCnt}" var="i">
            <a href="/goods/list?page=${i}&keyword=${keyword}">${i}</a>
        </c:forEach>
    </div>
</body>
</html>