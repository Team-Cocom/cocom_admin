<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/basic/genre_list.js"></script>
</head>
<body>
    <main>
        <div class="genre_list_area">
            <table>
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>장르 이름</td>
                        <td></td>
                    </tr>
                </thead>
            <c:forEach items="${list}" var="item" varStatus="stat">
                <tbody>
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.gr_name}</td>
                        <td>
                            <button class="delete_genre" data-name="${item.gr_name}" data-seq="${item.gr_seq}">삭제</button>
                        </td>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
        <button id="genre_popup_button">장르 정보 추가</button>
        </div>
        <div class="add_genre_popup" style="display: none;">
            <div class="add_genre_area">
                <p class>장르 이름</p>
                <input type="text" id="gr_name">
                <button id="add_genre">등록</button>
                <button id="cancel_genre">닫기</button>
            </div>
        </div>
    </main>
</body>
</html>