<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/basic/genre.js"></script>
</head>

<body>
    <main>
        <table>
            <thead>
                <tr>
                    <td>번호</td>
                    <td>장르이름</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.gr_name}</td>
                        <td>
                            <button class="delete" data-seq="${item.gr_seq}">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="genre_input_area">
            <p>장르이름</p>
            <input type="text" id="name">
            <button id="gr_save">등록</button>
        </div>
    </main>
</body>

</html>