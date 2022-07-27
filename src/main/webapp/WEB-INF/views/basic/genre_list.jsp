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
    <script src="/assets/js/basic/genre_info.js"></script>
    <link rel="stylesheet" href="/assets/css/basic/genre.css">
</head>
<body>
    <div class="genre_list_wrap">
        <button class="genre_add">장르 추가하기</button>
        <h1>장르 리스트</h1>
        <div class="genre_list">
            <p class="genre_list_title">
                <span class="no_title">No</span> <span class="name_title">장르명</span>
            </p>
        <c:forEach items="${genreList}" var="item" varStatus="stat">
            <p>
                <span>${stat.count}</span> <span> ${item.gr_name}</span>
                <span>
                    <button class="genre_del_btn" data-seq="${item.gr_seq}">삭제</button>
                </span> 
            </p>
        </c:forEach>
        <div class="genre_add_form">
            <p class="genre_name_add">장르이름</p>
            <input type="text" id="genre_name" placeholder="장르 이름을 입력하세요.">
            <button class="genre_add_btn">추가하기</button>
            <button class="genre_cancel_btn">닫기</button>
        </div>
        </div>
    </div>
</body>
</html>