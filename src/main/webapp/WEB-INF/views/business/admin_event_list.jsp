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
    <script src="/assets/js/business/eventlist.js"></script>
    <style>
        .event_detail{cursor: pointer;}
    </style>
</head>
<body>
    <main>
    관리자 이벤트 목록 페이지
    <div class="event_list_area">
        <form action="/admin/event/list">
            <input type="text" name="keyword" value="${keyword}">
            <button type="submit">검색</button>
        </form>
        <div class="event_list_wrap">
            <c:forEach items="${list}" var="item" varStatus="stat">
            <div class="event_img_area">
                <div class="event_img">
                    <p class="event_title">
                        <img src="/images/event_title/${item.eve_title_img}" class="event_detail" data-seq="${item.eve_seq}">
                    </p>
                    <p>이미지파일</p>
                </div>
              
                <div class="event_name">
                    <p class="event_title_name">${item.eve_name}</p>
                    <p>이벤트 이름</p>
                    <p>등록일</p>
                    <p>
                        <fmt:formatDate value="${item.eve_reg_dt}" pattern="yyyy-MM-dd"/>
                    </p>
                </div>
            </c:forEach>
            </div>
        </div>
    </div>
    <div class="pager_area">
        <c:forEach begin="1" end="${pageCnt}" var="i">
            <a href="/admin/event/list?page=${i}&keyword=${keyword}">${i}</a>
        </c:forEach>
    </div>
    <a href="/admin/event/add">추가하기</a>
</main>
</body>
<a href="/admin/event/detail">수정페이지</a>

</html>