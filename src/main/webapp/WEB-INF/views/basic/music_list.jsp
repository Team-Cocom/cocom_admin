<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/basic/music_list.css">
</head>
<body>
    <main>
        <a href="/music/add">노래 추가하기</a>
        <div class="music_list_area">
            <div class="search_box">
                <form action="/music/list" method="get">
                    <input type="text" name="keyword" placeholder="노래 제목 검색" value="${keyword}">
                    <button type="submit">검색</button>
                </form>
            </div>
            <div class="music_list_wrap">
                <c:forEach items="${list}" var="item" varStatus="stat">
                    <a href="/music/detail?music_no=${item.mu_seq}" class="music_list_item">
                        <div class="music_img" style="background-image: url('/images/music_cover/${item.mu_img_file}');"></div>
                        <p class="music_title">${item.mu_name}</p>
                        <p class="artis_info">아티스트</p>
                        <p class="audio">
                            <audio src="/images/music/${item.mu_music_file}" controls></audio>
                        </p>
                    </a>
                </c:forEach>
            </div>
        </div>
        <div class="pager_area">
            <c:forEach begin="1" end="${pageCnt}" var="i">
                <a href="/music/list?page=${i}&keyword=${keyword}">${i}</a>
            </c:forEach>
        </div>
    </main>
</body>
</html>