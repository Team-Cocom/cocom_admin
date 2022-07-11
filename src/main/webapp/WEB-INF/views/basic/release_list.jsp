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
    <script src="/assets/js/basic/release_list.js"></script>
</head>
<body>
    <main>
        <div class="release_list_area">
            <a href="/">메인으로고고</a>
            <table>
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>발매사 이름</td>
                        <td></td>
                    </tr>
                </thead>
            <c:forEach items="${list}" var="item" varStatus="stat">
                <tbody>
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.rci_name}</td>
                        <td>
                            <button class="delete_rci" data-seq="${item.rci_seq}">삭제</button>
                        </td>
                    </tr>
                </tbody>
            </c:forEach>
            </table>
            <button id="release_popup_button">발매사 정보 추가</button>
        </div>
        <div class="add_rci_popup" style="display: none;">
            <div class="add_rci_area">
                <p class>발매사 이름</p>
                <input type="text" id="rci_name">
                <button id="add_rci">등록</button>
                <button id="cancel_rci">닫기</button>
            </div>
        </div>
    </main>
</body>
</html>