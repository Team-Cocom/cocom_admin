<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/basic/music_add.js"></script>
</head>
<body>
    <main>
        <table class="music_add_area">
            <tbody>
                <tr>
                    <td>커버이미지</td>
                    <td>
                        <form id="cover_img_form">
                            <input type="file" name="file" id="music_cover_img" hidden>
                        </form>
                        <button id="cover_img_save" onclick="document.getElementById('music_cover_img').click()">커버 이미지 업로드</button>
                        <td class="cover_img_area"></td>
                    </td>
                    <td>노래제목</td>
                    <td>
                        <input type="text" id="mu_name" >
                    </td>
                    <td>아티스트</td>
                    <td>
                        <input type="text" value="아티스트 정보 필요">
                    </td>
                    <td>앨범정보</td>
                    <td>
                        <select id="ab_seq">
                            <option value="1">앨범 정보 필요</option>
                            <option value="2">앨범2</option>
                            <option value="3">앨범3</option>
                        </select>
                    </td>
                    <tr>
                        <td>
                            <form id="music_file_form">
                                <input type="file" name="file" id="music_file" hidden>
                            </form>
                            <button id="music_file_save" onclick="document.getElementById('music_file').click()">노래 업로드</button>
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
    </main>
</body>
</html>