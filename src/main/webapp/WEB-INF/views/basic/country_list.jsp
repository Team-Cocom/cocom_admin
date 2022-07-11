<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/basic/country_list.js"></script>
</head>
<body>
    <main>
        <div class="country_list_area">
            <table>
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>국가 명</td>
                        <td></td>
                    </tr>
                </thead>
            <c:forEach items="${list}" var="item" varStatus="stat">
                <tbody>
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.cr_name}</td>
                        <td>
                            <button class="delete_country" data-name="${item.cr_name}" data-seq="${item.cr_seq}">삭제</button>
                        </td>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
        <button id="country_popup_button">국가 정보 추가</button>
        </div>
        <div class="add_country_popup" style="display: none;">
            <div class="add_country_area">
                <p class>국가 이름</p>
                <input type="text" id="cr_name">
                <button id="add_country">등록</button>
                <button id="cancel_country">닫기</button>
            </div>
        </div>
    </main>
</body>
</html>