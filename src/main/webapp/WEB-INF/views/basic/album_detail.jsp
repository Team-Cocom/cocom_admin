<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/basic/album_detail.css">
</head>
<body>
    <main>
        <section class="movie_list_section">
        <div class="movieList openList on">
                <h2 class="movie_item open_list_item">
                    <div class="poster" style="background-image: url('/images/album_cover/${list[0].ab_img_file}');">
                        <div class="age_grade grade${list[0].ab_age}">
                            <c:if test="${list[0].ab_age == 0}">전체</c:if>
                            <c:if test="${list[0].ab_age != 0}">
                                성인
                            </c:if>
                        </div>
                    </div>
                    <div class="movie_item_txt">
                        <p class="movie_name">${list[0].ab_name}</p>
                        <p class="opening_dt">
                            발매일<fmt:formatDate value="${list[0].ab_re_dt}" pattern="yyyy.MM.dd"/>
                        </p>
                        <p>발매사 <span>${list[0].rci_name}</span></p>
                        <p>기획사 <span>${list[0].ent_name}</span></p>
                    </div>
                </h2>    
        </div>
    </section>
        <table>
            <thead>
                <tr>
                    <td>번호</td>
                    <td>노래커버</td>
                    <td>제목</td>
                    <td>장르</td>
                    <td>노래파일</td>
                    <td></td>
                    <td>나이</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.mu_name}</td>
                        <td>
                            <div class="poster_img"
                            style="background-image:url('/images/music_cover/${item.mu_img_file}');
                            width:60px; height:80px; background-size: auto 100%;
                            background-repeat: no-repeat;"
                            </div>
                        </td>
                        <td>${item.gr_name}</td>
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
    </main>
</body>
</html>