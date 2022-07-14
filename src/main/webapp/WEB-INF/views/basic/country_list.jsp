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
    <script src="/assets/js/basic/country_info.js"></script>
</head>
<body>
    <button class="country_add">나라 추가하기</button>
    <div class="country_list">나라 리스트</div>
    <c:forEach items="${list}" var="item" varStatus="stat">
        <p>
            <span>번호</span>${stat.count} <span> ${item.cr_name}</span>
            <span>
                <button class="country_del_btn" data-seq="${item.cr_seq}">삭제</button>
            </span> 
        </p>
    </c:forEach>
    
    <p class="country_name_add">나라이름</p>
    <input type="text" id="country_name" placeholder="나라 이름을 입력하세요.">
    <button class="country_add_btn">추가하기</button>
    
    
</body>
</html>