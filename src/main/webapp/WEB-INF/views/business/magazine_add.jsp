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
    <script src="/assets/js/business/magazine_add.js"></script>
</head>
<body>
    <table>
        <thead>
            <td>매거진 이름</td>
            <td><input type="text" id="mz_name" placeholder="매거진 이름을 입력하세요"></td>
            <div class = "magazine_img_input">
                <p>매거진 포스터</p>
                <form id="magazine_poster_img">
                    <input type="file" name="file" id="mz_poster_img" hidden> 
                </form>
                <button id="file_save" onclick="document.getElementById('mz_poster_img').click()">파일선택</button>
                <button id="file_del">프로필 이미지 제거</button>
            </div>
            <div class="magazine_img_area">

            </div>
            <td></td>
        </thead>
        <tbody>
            <td><button class="add_magazine">추가하기</button></td>
        </tbody>
    </table>
</body>
</html>