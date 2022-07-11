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
    <script src="/assets/js/basic/enter_list.js"></script>
</head>
<body>
    <main>
        <div class="enter_list_area">
            <a href="/">메인으로고고</a>
            <table>
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>기획사 이름</td>
                        <td></td>
                    </tr>
                </thead>
            <c:forEach items="${list}" var="item" varStatus="stat">
                <tbody>
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.ent_name}</td>
                        <td>
                            <button class="delete_ent" data-seq="${item.ent_seq}">삭제</button>
                        </td>
                    </tr>
                </tbody>
            </c:forEach>
            </table>
            <button id="enter_popup_button">기획사 정보 추가</button>
        </div>
        <div class="add_ent_popup" style="display: none;">
            <div class="add_ent_area">
                <p class>기획사 이름</p>
                <input type="text" id="ent_name">
                <button id="add_ent">등록</button>
                <button id="cancel_ent">닫기</button>
            </div>
        </div>
    </main>
</body>
</html>