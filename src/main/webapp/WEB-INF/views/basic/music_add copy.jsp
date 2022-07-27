<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/basic/music_add.js"></script>
    <link rel="stylesheet" href="/assets/css/basic/music_add.css">
</head>

<body>
    <main>
        <c:if test="${music_no == null}">
            <div class="music_add_wrap">
                <table class="music_add_area">
                    <tbody>
                        <tr>
                            <td>커버이미지</td>
                            <td>
                                <form id="cover_img_form">
                                    <input type="file" name="file" id="music_cover_img" hidden>
                                </form>
                                <button id="cover_img_save"
                                    onclick="document.getElementById('music_cover_img').click()">커버
                                    이미지 업로드</button>
                            <td class="cover_img_area"></td>
                            </td>
                            <td>노래제목</td>
                            <td>
                                <input type="text" id="mu_name">
                            </td>
                            <td>장르</td>
                            <td>
                                <select id="mu_gr_seq">
                                    <c:forEach items="${genre_list}" var="item">
                                        <option value="${item.gr_seq}">${item.gr_name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>국가</td>
                            <td>
                                <select id="mu_cr_seq">
                                    <c:forEach items="${country_list}" var="item">
                                        <option value="${item.cr_seq}">${item.cr_name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>아티스트</td>
                            <td>
                                <c:forEach items="${artist_list}" var="item">
                                    <select id="ai_seq">
                                    <option value="${item.ai_seq}">${item.ai_name}</option>
                                </select>
                                </c:forEach>
                            </td>
                        <tr>
                            <td>
                                <form id="music_file_form">
                                    <input type="file" name="file" id="music_file" hidden>
                                </form>
                                <button id="music_file_save" onclick="document.getElementById('music_file').click()">노래
                                    업로드</button>
                                <div class="music_file_area"></div>
                            </td>
                            <td>플레이타임</td>
                            <td>
                                <input type="number" id="mu_playtime">초
                            </td>
                            <td>청취연령</td>
                            <td>
                                <select id="mu_age">
                                    <option value="0">전체</option>
                                    <option value="19">19세 이상</option>
                                </select>
                            </td>
                            <td>가사</td>
                            <td>
                                <textarea id="mu_lylic" cols="30" rows="10"></textarea>
                            </td>
                            <td>노래 설명</td>
                            <td>
                                <textarea id="mu_explain" cols="30" rows="10"></textarea>
                            </td>
                        </tr>
                        </tr>
                    </tbody>
                </table>
                <button id="add_music">노래 추가</button>
            </div>
        </c:if>

        <c:if test="${music_no != null}">
            <div class="music_mod_area">
                <p>커버 이미지</p>
                <form id="cover_img_mod_form">
                    <input type="file" name="file" id="music_cover_mod_img" hidden>
                </form>
                <button id="cover_img_mod_save" onclick="document.getElementById('music_cover_mod_img').click()">커버
                    이미지 변경</button>
                </span><span class="img_file">
                    <c:if test="${list.mu_img_file != ''}">
                        <div class="music_img_mod" data-name="${list.mu_img_file}"
                            style="background-image: url( /images/music_cover/${list.mu_img_file});">
                            <button onclick="deleteModImg('${list.mu_img_file}')">&times;</button>'
                        </div>
                    </c:if>
                </span></p>
                <p>노래제목 변경 <span><input type="text" id="mu_mod_name" value="${list.mu_name}"></span></p>
                <p>장르 변경 <span><select id="mu_gr_seq_mod">
                            <c:forEach items="${genre_list}" var="item">
                                <option value="${item.gr_seq}" <c:if test="${item.gr_seq == list.mu_gr_seq}">selected
        </c:if>>${item.gr_name}</option>
        </c:forEach>
        </select></span></p>
        <p>국가 변경 <span> <select id="mu_cr_seq_mod">
                    <c:forEach items="${country_list}" var="item">
                        <option value="${item.cr_seq}" <c:if test="${item.cr_seq == list.mu_cr_seq}">selected</c:if>
                            ${item.cr_name}</option>
                    </c:forEach>
                </select></span></p>
        <p>아티스트 변경 <span><input type="text" value="${list.mu_ai_seq}"></span></p>
        <p>앨범 정보 변경<span><select id="mod_ab_seq">
                    <option value="1" <c:if test="${list.mu_ab_seq == 1}">selected</c:if>>앨범 정보 필요</option>
                    <option value="2" <c:if test="${list.mu_ab_seq == 2}">selected</c:if>>앨범2</option>
                    <option value="3" <c:if test="${list.mu_ab_seq == 3}">selected</c:if>>앨범3</option>
                </select></span></p>
        플레이타임 변경
        <input type="number" id="mu_playtime_mod" value="${list.mu_playtime}">초
        <p>
        앨범 정보 변경<span>
            <select id="mu_age_mod">
                <option value="0" <c:if test="${list.mu_age == 0}">selected</c:if>>전체</option>
                <option value="19" <c:if test="${list.mu_age == 19}">selected</c:if>>19세 이상</option>
            </select></span>
        </p>
            <form id="music_file_mod_form">
                <input type="file" name="file" id="music_file_mod" hidden>
            </form>
            <button id="music_file_save_mod" onclick="document.getElementById('music_file_mod').click()">노래
                변경</button>
            <div class="music_file_area_mod">
                <c:if test="${list.mu_music_file != ''}">
                    <audio controls class="music_file_mod" data-name="${list.mu_music_file}">
                        <source src="/images/music/${list.mu_music_file}" type="audio/mp3">
                    </audio>
                    <button onclick="delete_music_file_mod('${list.mu_music_file}')">&times;</button>
                </c:if>
            </div>
            <div class="mod_right_area">
                <p>
                    노래 설명 변경 <span><textarea id="mu_lylic_mod" cols="30" rows="10">${list.mu_explain_txt}</textarea></span>
                </p>
                <button id="mod_music" data-seq="${list.mu_seq}">노래 수정</button>
            </div>
            </div>
            </c:if>
    </main>
</body>

</html>