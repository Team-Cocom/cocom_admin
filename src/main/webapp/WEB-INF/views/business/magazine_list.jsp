<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="/assets/js/business/magazine_list.js"></script>
    <link rel="stylesheet" href="/assets/css/business/magazine.css">
</head>
<body>
    <main>
        <div class="magazine_list_section">
            <c:forEach items="${list}" var="item" varStatus="stat">
                <a href="/magazine/detail?magazine_no=${item.mz_seq}" class="magazine_list_item">
                    <div class="magazine_img" style="background-image: url('/images/magazine_img/${item.mz_poster_img}');"></div>
                    <p class="magazine_title">${item.mz_name}</p>
                </a>
                    <button class="del_magazine_btn" data-seq="${item.mz_seq}"> 삭제</button>
            </c:forEach>
        </div>
        <div id="magazine_add_area">
            <a href="/magazine/add">매거진 정보 추가</a>
            <a href="/magazine/desc">매거진 게시글 추가</a>
        </div>
    </main>
</body>
</html>