<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/post/notice_detail.js"></script>
</head>

<body>
    <main>
        <button id="modify_notice">수정하기</button>
        <div class="notice_detail_area">
            <table>
                <thead>
                    <tr>
                        <td>제목</td>
                        <td>작성일</td>
                        <td>수정일</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${noticeList.ni_title}</td>
                        <td>
                        </td>
                        <td>
                            <fmt:formatDate value="${noticeList.ni_reg_dt}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${noticeList.ni_mod_dt}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td></td>
                    </tr>
                    <td class="post_text_area">
                        ${noticeList.ni_ex_text}
                    </td>
                    <td class="post_img_area">
                        <c:if test="${noticeList.ni_img_file != ''}">
                        <img src="/images/notice_img/${noticeList.ni_img_file}" class="ni_detail_info"
                            data-seq="${noticeList.ni_seq}" data-name="{${noticeList.ni_img_file}}">
                        </c:if>
                    </td>
                </tbody>
            </table>
        </div>
        <div class="notice_mod_area">
            <table>
                <thead>
                    <tr>
                        <td>제목</td>
                        <td>공지사항 중요도</td>
                        <td>공지 이미지</td>
                        <td>공지 내용</td>
                        <td>작성일</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <input type="text" id="ni_mod_title" value="${noticeList.ni_title}">
                        </td>
                        <td>
                            <select id="ni_mod_import">
                                <option value="0" <c:if test="${noticeList.ni_import == 0}">selected</c:if>>일반</option>
                                <option value="1" <c:if test="${noticeList.ni_import != 0}">selected</c:if>>중요</option>
                            </select></span>
                        </td>
                        <td class="notice_img_mod_area" data-name="${noticeList.ni_img_file}">
                            <c:if test="${noticeList.ni_img_file != ''}">
                                <img src="/images/notice_img/${noticeList.ni_img_file}" class="notice_img_detail">
                                <button class="delete_img" data-seq="${noticeList.ni_seq}">&times;</button>
                            </c:if>
                            <form id="ni_img_form">
                                <input type="file" name="file" id="ni_mod_file" hidden>
                            </form>
                            <button id="ni_img_mod_btn" onclick="document.getElementById('ni_mod_file').click()">이미지 변경</button>
                            <div class="ni_mod_img_area">

                            </div>
                        </td>
                        <td>
                            <textarea id="ni_ex_text_mod" cols="30" rows="10"> ${noticeList.ni_ex_text}</textarea>
                        </td>
                        <td>
                            <fmt:formatDate value="${noticeList.ni_reg_dt}" pattern="yyyy-MM-dd" />
                        </td>
                </tbody>
            </table>
            <button id="mod_save" data-seq="${noticeList.ni_seq}">수정</button>
            <button id="cancel_mod">취소</button>
        </div>
    </main>
</body>

</html>
