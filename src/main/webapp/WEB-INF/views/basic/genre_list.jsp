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
</head>
<body>
    <button class="genre_add">장르 추가하기</button>
    <div class="genre_list">장르 리스트</div>
<<<<<<< HEAD
    <c:forEach items="${list}" var="item" varStatus="stat">
=======
    <c:forEach items="${genreList}" var="item" varStatus="stat">
>>>>>>> 981ced219b2c0ac681179c8f8f848888e87548c7
        <p>
            <span>번호</span>${stat.count} <span> ${item.gr_name}</span>
            <span>
                <button class="genre_del_btn" data-seq="${item.gr_seq}">삭제</button>
            </span> 
        </p>
    </c:forEach>
<<<<<<< HEAD
    
=======
>>>>>>> 981ced219b2c0ac681179c8f8f848888e87548c7
    <p class="genre_name_add">장르이름</p>
    <input type="text" id="genre_name" placeholder="장르 이름을 입력하세요.">
    <button class="genre_add_btn">추가하기</button>
    <button class="genre_cancel_btn">닫기</button>
<<<<<<< HEAD
    
    
=======
>>>>>>> 981ced219b2c0ac681179c8f8f848888e87548c7
</body>
</html>