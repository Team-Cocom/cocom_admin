<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/basic/album_info.js"></script>
</head>
<body>
    <main>
        <h1>앨범 정보
        <div class="basic_info">
            <table>
                <tbody>
                    <tr>
                        <tr>
                            <td>앨범명</td>
                            <td>
                                <input type="text" id="ab_name" placeholder="앨범명을 입력하세요.">     
                            </td>
                            <td>아티스트명</td>
                            <td>
                                <input type="text" id="ai_name" value="아티스트 정보 필요">
                            </td>
                            <td>장르</td>
                            <td>
                                <input type="text" id="gr_name">
                            </td>
                            <td>청취연령</td>
                            <td>
                                <select id="ab_age">
                                    <option value="0">전연령</option>
                                    <option value="19">19세 이상</option>
                                </select>
                            </td>
                        </tr>
                        <tr>                 
                            <td>발매일</td>
                            <td>
                                <input type="text" id="ab_re_dt" placeholder="yyyy-mm-dd">
                            </td>
                            <td>소속사</td>
                            <td>
                                <select id="ab_ent_seq">
                                    <c:forEach items="${enterList}" var="item">
                                        <option value="${item.ent_seq}">${item.ent_name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>발매사</td>
                            <td>
                                <select id="ab_rci_seq">
                                    <c:forEach items="${relList}" var="item">
                                        <option value="${item.rci_seq}">${item.rci_name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>뮤직비디오</td>
                            <td>
                                <select id="ab_mv_seq">
                                    <option value="1">앨범정보 필요</option>
                                </select>
                            </td>
                            <td>노래정보</td>
                            <td>
                                <select id="ab_mu_seq">
                                    <option value="1">노래정보 필요</option>
                                </select>
                            </td>
                        </tr>
                    </tr>
                </tbody>
            </table>
            <div class="album_cover_area">
                <form id="album_cover_form">
                    <input type="file" name="file" id="album_cover_file" hidden accept = "image/gif, image/jpeg, image/png">
                </form>
                <div class="album_cover_list">
                    <div class="ab_covers">
                    </div>
                </div>
                <button id="add_ab_cover" onclick="document.getElementById('album_cover_file').click()">앨범 표지 선택</button>
            </div>
            <div class="album_explain">
                <textarea id="ab_ex_text" cols="30" rows="10"></textarea>
            </div>
            <button id="ab_add_save">추가</button>
            <button id="ab_add_cancel">취소</button>
    </main>
</div>
</body>
</html