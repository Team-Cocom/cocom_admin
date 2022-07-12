<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/business/admin_recommend_list.css">
</head>

<body>
    <main>
        <div class="admin_recommend_list_wrap">
            <h1>✨오늘의 추천 리스트</h1>
            <c:forEach items="${list}" var="item" varStatus="stat">
                <a href="/admin/recommend/list?title=${item.ard_title}" class="admin_list_item">
                    <div class="music_img" style="background-image: url('/images/music_cover/${item.mu_img_file}');">
                    </div>
                    <p class="list_title">${item.ard_title}</p>
                    <p class="music_title">${item.mu_name}</p>
                </a>
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
            </c:forEach>
        </div>
        <section class="recommend_list_section">
            <h1>☂💧비 오는날 듣기 좋은 플리</h1>
            <div class="recommend_list_area">
                    <c:forEach items="${genre_list}" var="item">
                        <a href="/admin/recommend/list?title=${item.ard_title}" target="_blank"class="recommend_item">
                            <div class="recommend_img" style="background-image: url('/images/music_cover/${item.mu_img_file}');">
                            </div>
                            <div class="recommend_item_txt">
                                <p class="recommend_title">${item.ard_title}</p>
                                <p class="recommend_name">${item.mu_name}<span>...</span></p>
                            </div>
                        </a>
                    </c:forEach>
            </div>
        </section>
        <section class="starpost_section">
            <h1>유저님의 취향저격 노래📢</h1>
            <a href="#">
                <div class="music_list_wrap">
                    <c:forEach items="${musicList}" var="item" varStatus="stat">
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
            </a>
        </section>
        <section class="recommend_list_section">
            <h1>신나는 음악 틀어놓고 새벽 드라이브 어때😎🚗</h1>
            <div class="recommend_list_area">
                <c:forEach items="${artist_list}" var="item">
                    <a href="/admin/recommend/list?title=${item.ard_title}" target="_blank"class="recommend_item">
                        <div class="recommend_img" style="background-image: url('/images/music_cover/${item.mu_img_file}');">
                        </div>
                        <div class="recommend_item_txt">
                            <p class="recommend_title">${item.ard_title}</p>
                            <p class="recommend_name">${item.mu_name}<span>...</span></p>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </section>
        <section class="recommend_section">
            <h1>이런 노래는 어떠신가요?❔</h1>
            <a href="#">
                <div class="music_list_wrap">
                    <c:forEach items="${music_recommend}" var="item" varStatus="stat">
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
            </a>
        </section>
        <section class="recommend_list_section">
            <h1>감성 가득한 여름밤, 신선한 밤공기 무드 노래들 🎇</h1>
            <div class="recommend_list_area">
                    <c:forEach items="${album_list}" var="item">
                        <a href="/admin/recommend/list?title=${item.ard_title}" target="_blank"class="recommend_item">
                            <div class="recommend_img" style="background-image: url('/images/music_cover/${item.mu_img_file}');">
                            </div>
                            <div class="recommend_item_txt">
                                <p class="recommend_title">${item.ard_title}</p>
                                <p class="recommend_name">${item.mu_name}<span>...</span></p>
                            </div>
                        </a>
                    </c:forEach>
            </div>
        </section>
    </main>
</body>

</html>