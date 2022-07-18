<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/post/notice.js"></script>
    <link rel="stylesheet" href="/assets/css/post/notice.css">
</head>

<body>
    <main>
        <button id="notice_popup_button">공지추가</button>
        <div class="search_box">
            <form action="/notice" method="get">
                <input type="text" name="keyword" placeholder="공지 검색" value="${keyword}">
                <button type="submit">검색</button>
            </form>
        </div>
        <div class="notice_list_area">
            <table class="item_list">
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>공지타이틀</td>
                        <td>등록일</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="item" varStatus="stat">
                        <tr>
                            <td>${stat.count}</td>
                            <td>
                                <a href="/post/detail?post_no=${item.ni_seq}">${item.ni_title}</a>
                            </td>
                            <td>
                                <fmt:formatDate value="${item.ni_reg_dt}" pattern="yyyy-MM-dd" />
                            </td>
                            <td>
                                <button class="del_btn" data-seq="${item.ni_seq}">삭제</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="notice_add_popup">
            <div class="notice_add_area">
                <p>공지사항 타이틀</p>
                <input type="text" id="ni_title">
                <p>공지사항 내용</p>
                <textarea id="ni_ex_text" cols="30" rows="10"></textarea>
                <p>중요여부</p>
                <select id="ni_import">
                    <option value="0">일반</option>
                    <option value="1">중요</option>
                </select>
                <p>공지사항 이미지</p>
                <form id="notice_form">
                    <input type="file" name="file" id="notice_img" hidden>
                </form>
                <div class="notice_img_area">
                </div>
                <button id="notice_img_button" onclick="document.getElementById('notice_img').click()">이미지등록</button>
                <button id="notice_add">등록</button>
                <button id="notice_cancel">취소</button>
            </div>
        </div>
        <div class="pager_area">
            <c:forEach begin="1" end="${pageCount}" var="i">
                <a href="/notice?page=${i}&keyword=${keyword}">${i}</a>
            </c:forEach>
        </div>
    </main>
</body>

</html>