<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/prc.js"></script>
</head>
<body>
    <main>
        <h1>prc</h1>
        <div class="prc_img_area">
            <form id="prc_img_form">
                <input type="file" name="file" id="prc_img_file" hidden accept="image/gif, image/jpeg, image/png">
            </form>
            <div class="prc_img_v">
                <div class="prc_v">

                </div>
            </div>
        </div>
        <button id="loopy_ent_add" onclick="document.getElementById('prc_img_file').click()">루피엔터이미지</button>
        <p>-------------------------------------------------------------------------</p>
        <div class="wonky_img_area">
            <form id="wk_form">
                <input type="file" name="file" id="wk_img_file" hidden accept="image/gif, image/png, image/jpeg">
            </form>
            <div class="m_img_story">
                <div class="m_img">

                </div>
            </div>
        </div>
        <button id="wonky_add" onclick="document.getElementById('wk_img_file').click()">웡키추가하자</button>
        <p>-------------------------------------------------------------------------</p>
    </main>
</body>
</html>