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
    <script src="/assets/js/business/event_detail.js"></script>

</head>

<body>
    이벤트 상세 페이지
    <main>
        <button class="modify_detail">내용수정하기</button>
        <div class="event_detail_wrap">
            <table class="event_detail_area">
                <tbody>
                    <tr>
                            <td>표지 이미지</td>
                            <td>이벤트 이름</td>
                            <td>디테일 이미지</td>
                            <td>디테일 내용</td>
                            <td></td>

                    </tr>
                        <td>
                            <p class="event_title_detail_img_area" data-name="${list.eve_title_img}">
                                <c:if test="${list.eve_title_img != ''}">
                                    <div class="isimgTrue">
                                        <img src="/images/event_title/${list.eve_title_img}" class="event_title_img" data-name="${list.eve_title_img}">
                                        <button id="deleteTitleImg" data-file="${list.eve_title_img}">&times;</button>
                                    </div>
                            </c:if>
                                <form id="event_title_img_mod_form">
                                <input type="file" name="file" id="event_title_mod_img" hidden>
                            </form>
                                <button id="event_title_img_mod_btn" onclick="document.getElementById('event_title_mod_img').click()">변경이미지 업로드</button>
                                <p class="event_title_mod_img_area">
                                    
                                </p>
                            </p>
                        </td>
                        <td>
                            <input type="text" id="event_name_mod" value="${list.eve_name}"> <span></span></input>
                        </td>
                        <td>
                            
                            <p>
                                <c:if test="${list.eve_img_file != ''}">
                            <img src="/images/event_desc/${list.eve_img_file}" class="event_desc_img"
                                data-name="${list.eve_img_file}">
                                <button id="deleteDescImg" data-file="${list.eve_img_file}">&times;</button>
                                </c:if>
                                <form id="event_desc_img_mod_form">
                                <input type="file" name="file" id="event_desc_mod_img_select" hidden>
                            </form>
                                <button id="event_desc_img_mod_btn" onclick="document.getElementById('event_desc_mod_img_select').click()">이벤트 상세이미지 업로드</button>
                                <p class="event_desc_mod_img_area">

                                </p>
                            </p>
                            <div class="event_title_img_mod">

                            </div>
                            <div class="event_desc_img_mod_area">

                            </div>

                        </td>
                        <td>
                            <textarea id="event_desc_mod" cols="30" rows="10" >${list.eve_ex_text}</textarea>
                        </td>
                        <td>
                            <button id="mod_event" data-seq="${list.eve_seq}">수정</button>
                            <button class="delete_event_info" data-seq="${list.eve_seq}">삭제</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <a href="/admin/event/list">이벤트 목록</a>
    </main>



</body>

</html>