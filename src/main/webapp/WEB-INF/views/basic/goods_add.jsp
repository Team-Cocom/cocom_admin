<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/basic/goods_add.js"></script>
</head>
<body>
    <h1>굿즈사이트에오</h1>
    <div class="basic_info">
        <h1>굿즈 기본 정보</h1>
        <table class="goods_info">
            <tbody>
                <tr>
                    <td>제품명</td>
                    <td colspan="3">
                        <input type="text" id="gz_name">
                    </td>
                    <td>가격</td>
                    <td>
                        <input type="number" id="gz_price" value="0">
                    </td>
                    <td>재고</td>
                    <td>
                        <input type="number" id="gz_stock" value="0">
                    </td>
                </tr>
                <tr>
                    <tr>
                        <td colspan="5">공지사항</td>
                    </tr>
                    <tr>
                        <td colspan="5" class="content_td">
                            <textarea name="gz_notice"></textarea>
                        </td>
                    <tr>
                        <td colspan="5">제품설명</td>
                    </tr>
                        <td colspan="5" class="content_td">
                            <textarea name="gz_ex_text"></textarea>
                        </td>
                    </tr>    
                </tr>
            </tbody>
        </table>
    </div>
    <div class="goods_img_area">
        <form id="goods_img_form" data-name="">
            <input type="file" name="file" id="goods_img_file" hidden accept = "image/gif, image/jpeg, image/png">
        </form>
        <div class="goods_imgs">
            <div class="img_list"                        
        </div>
        <button id="browse" onclick="document.getElementById('goods_img_file').click()">이미지선택</button>
    </div>
    <button id="gz_add_save">추가</button>
    <button id="gz_add_cancel">취소</button>
</div>
<div class="pager_area">
    <c:forEach begin="1" end="${pageCnt}" var="i">
        <a href="/release/list?page=${i}&keyword=${keyword}">${i}</a>
    </c:forEach>
</div>
</body>
</html



<%-- <tr class="btn_tr">
    <td colspan="5">
        <button type="submit">등록하기</button>
    </td>
</tr> --%>