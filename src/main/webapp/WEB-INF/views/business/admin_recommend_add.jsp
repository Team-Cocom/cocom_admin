<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/business/admin_recommend_add.js"></script>
</head>
<body>
    <main>
        <div class="add_admin_playlist_area">
            <h1>재생목록 타이틀</h1>
            <input type="text" id="ard_title">
            <div class="admin_playlist_add">
                <p>노래 제목</p>
                <input type="text" id="music_name">
                <div class="admin_playlist_button_area">
                    <p>노래 파일</p>
                    <form id="ad_music_form">
                        <input type="file" name="file" id="add_music" hidden>
                    </form>
                    <button id="add_music_save" onclick="document.getElementById('add_music').click()">노래 업로드</button>
                    <div class="add_music_area">

                    </div>
                </div>
                <p>앨범정보</p>
                <input type="text" placeholder="앨범정보 추가가 필요합니다">
            </div>
            <button id="playlist_save">재생목록에 추가</button>
        </div>
    </main>
</body>

</html>