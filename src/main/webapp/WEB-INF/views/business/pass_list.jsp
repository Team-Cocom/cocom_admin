<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/business/pass.css">
    <script src="/assets/js/business/pass.js"></script>
</head>

<body>
    <main>
        <button id="pass_popup">이용권 추가</button>
        <div class="pass_list_area">
            <div class="search_box">
                <form action="/pass/list" method="get">
                    <input type="text" name="keyword" placeholder="이용권 검색" value="${keyword}">
                    <button type="submit">검색</button>
                </form>
            </div>
            <table class="item_list">
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>이용권 이름</td>
                        <td>이용권 타입</td>
                        <td>이용권 이미지</td>
                        <td>이용권 가격</td>
                        <td>이용권 기간</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${passList}" var="item" varStatus="stat">
                        <tr>
                            <td>${stat.count}</td>
                            <td>${item.ps_name}</td>
                            <td>
                                <c:if test="${item.ps_type == 1}">전체</c:if>
                                <c:if test="${item.ps_type == 2}">VIP회원</c:if>
                                <c:if test="${item.ps_type == 3}">VVIP회원</c:if>
                            </td>
                            <td>
                                <img src="/images/pass_img/${item.ps_img_file}" class="ps_img" data-file="${item.ps_img_file}">
                            </td>
                            <td>
                                <fmt:formatNumber value="${item.ps_price}" pattern="#,##0"/>원
                            </td>
                            <td>${item.ps_period}일</td>
                            <td>
                                <button id="delete_pass">삭제</button>
                            </td>
                        </tr>
                    </c:forEach>
                    <div class="ps_origin_img" style="display: none;">
                        <button id="ps_origin_cancel">닫기</button>
                    </div>
                </tbody>
            </table>
        </div>
        <div class="pass_add_popup_wrap">
            <div class="pass_add_area">
                <form id="pass_img_form">
                <input type="file" name="file" hidden id="ps_img_file">
                </form>
                <button id="pass_img_save" onclick="document.getElementById('ps_img_file').click()">이용권 사진
                    업로드</button>
                    </span><span class="img_file">
                        
                    </span></p>
                <p>이용권 이름 <span><input type="text" id="ps_name"></span></p>
                <p>이용권 기간 <span><input type="number" id="ps_period">일</span></p>
                <p>이용권 가격 <span><input type="number" id="ps_price">원</span></p>
                <p>이용권 타입 <span><select id="ps_type">
                            <option value="1">전체</option>
                            <option value="2">VIP회원</option>
                            <option value="3">VVIP회원</option>
                        </select></span></p>
                <button id="add_pass">등록</button>
                <button id="cancel_pass">취소</button>
            </div>
        </div>
        <div class="pager_area">
            <c:forEach begin="1" end="${pageCount}" var="i">
                <a href="/pass/list?page=${i}&keyword=${keyword}">${i}</a>
            </c:forEach>
        </div>
    </main>
</body>

</html>