<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <main>
        <section>
            <nav>
                <ul>
                    <c:forEach items="${list}" var="item">
                    <a href="/admin/recommend/list?title=${item.ard_title}">${item.ard_title}</a>
                    </c:forEach>
                </ul>
            </nav>
        </section>
    </main>
</body>
</html>