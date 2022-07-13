<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .player {width: 800px; height: 800px; position: absolute; top: 50%; left: 50%;
            margin-left: -400px; margin-top: -400px; border: 1px solid #000;
        }
        .player > div {
            display: inline-block; vertical-align: top;
        }
        #play_music_img {width: 350px; height: 350px; border: 1px solid #000; background-color: #f7f7f7;}
        #play_music_title {font-size: 22px; font-weight: bold;}
    </style>
    <script>
        let now_playing = 0;
        let total = ${list.size()}
        $(function(){
            $(".play_item").click(function(){
                now_playing = $(this).index();
                let img = $(this).find(".img").val();
                let music = $(this).find(".music").val();
                $("#play_music_img").css("background-image", "url('"+img+"')");
                $("#play_music").attr("src", music);
                document.getElementById('play_music').play();
            })
            
            document.getElementById('play_music').ontimeupdate = function(){
                if(this.duration == this.currentTime) {
                    if(now_playing == total-1) {
                        now_playing = 0;
                    }
                    else {
                        now_playing++;
                    }
                    $(".play_item").eq(now_playing).trigger('click');
                    this.play();
                }
            }
        })
    </script>
</head>
<body>
    <main>
        <%--
        <table>
            <thead>
                <tr>
                    <td>번호</td>
                    <td>장르이름</td>
                    <td>앨범이름</td>
                    <td>노래커버</td>
                    <td>노래제목</td>
                    <td></td>
                    <td>청취연령</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item" varStatus="stat">
                <tr>
                        <td>${stat.count}</td>
                        <td>장르 </td>
                        <td>앨벌앨범</td>
                        <td>
                            <img src="/images/music_cover/${item.mu_img_file}">
                        </td>
                        <td>${item.mu_name}</td>
                        <td>
                            <audio src="/images/music/${item.mu_music_file}" controls></audio>
                        </td>
                        <td>
                            <c:if test="${item.mu_age == 0}">전체</c:if>
                            <c:if test="${item.mu_age == 19}">성인</c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        --%>
        <div class="player">
            <div class="now_playing">
                <div id="play_music_img">

                </div>
                <audio src="/sample.mp3" id="play_music" controls></audio>
                <h2 id="play_music_title"></h2>
            </div>
            <div class="playlist">
                <c:forEach items="${list}" var="item" varStatus="stat">
                <div class="play_item">
                    <input type="text" class="img" value="/images/music_cover/${item.mu_img_file}" hidden>
                    <input type="text" class="music" value="/images/music/${item.mu_music_file}" hidden>
                    <span class="no">${stat.count}</span>
                    <span class="name">
                        <i class="rate">
                            <c:if test="${item.mu_age == 0}">전체</c:if>
                            <c:if test="${item.mu_age == 19}">성인</c:if>
                        </i>
                        <b>${item.mu_name}</b>
                    </span>
                </div>
                </c:forEach>
            </div>
        </div>
    </main>
</body>
</html>