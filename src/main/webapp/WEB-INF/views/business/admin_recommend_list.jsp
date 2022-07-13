<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Document</title>
        <script src="/assets/js/business/admin_recommend_list.js"></script>
        <link rel="stylesheet" href="/assets/css/business/admin_recommend_list.css">
    </head>
    <body>
        <main>
            <button id="playlist_popup_open">재생목록 추가</button>
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
        <div class="recommend_list_wrap">
        <section class="recommend_list_section">
            <h1>☂💧비 오는날 듣기 좋은 플리</h1>
            <div class="recommend_list_area">
                    <c:forEach items="${genre_list}" var="item">
                        <a href="/admin/recommend/list?title=${item.ard_title}" class="recommend_item">
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
        <section class="recommend_list_section">
            <h1>신나는 음악 틀어놓고 새벽 드라이브 어때😎🚗</h1>
            <div class="recommend_list_area">
                <c:forEach items="${artist_list}" var="item">
                    <a href="/admin/recommend/list?title=${item.ard_title}" class="recommend_item">
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
        <section class="recommend_list_section">
            <h1>감성 가득한 여름밤, 신선한 밤공기 무드 노래들 🎇</h1>
            <div class="recommend_list_area">
                    <c:forEach items="${album_list}" var="item">
                        <a href="/admin/recommend/list?title=${item.ard_title}" class="recommend_item">
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
    </div>
    <div class="admin_playlist_popup_wrap">
    <div class="add_admin_playlist_area">
        <div class="add_admin_item">
        <h1>재생목록 타이틀</h1>
        <input type="text" id="ard_title" placeholder="재생목록 이름">
        <div class="admin_playlist_add">
            <p>노래 제목</p>
            <input type="text" id="music_name" placeholder="노래 제목">
            <div class="admin_playlist_button_area">
                <p>노래 파일추가</p>
                    <input type="text" id="add_music">
                <div class="add_music_area">
                </div>
            </div>
            <p>앨범정보</p>
            <input type="text" placeholder="앨범정보 추가가 필요합니다">
        </div>
        <button id="playlist_save">등록</button>
        <button id="cancel_playlist">닫기</button>
    </div>
</div>
</div>
<div class="music_search_popup" style="display:none; border:1px solid #000">
    <div class="music_search_form">
        <h2>배우 검색</h2>
        <input type="text" id="music_search_keyword">
        <button id="music_search_button">검색</button>
        <div class="music_search_list">
            <table>
                <thead>
                    <tr>
                        <td>노래커버</td><td>노래제목</td>장르<td></td><td></td><td></td>
                    </tr>
                </thead>
                <tbody>
                    
                </tbody>
            </table>
        </div>
        <div class="music_search_pager_area">

        </div>
    </div>
</div>
    </main>
</body>

</html>