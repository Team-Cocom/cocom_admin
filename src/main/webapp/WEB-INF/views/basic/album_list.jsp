<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="/assets/js/basic/album_info.js"></script>
    <style>
        .ab_detail_info{cursor: pointer;}
    </style>
</head>
<body>
    <main>
        <h1>앨범 정보 관리</h1>
        <a href="/album/add" id="add_album_info">
            <i class="fas fa-plus-square"></i>
            <span>앨범 정보 추가</span>
        </a>
        <div class="search_area">
            <form action="/album/list">
                <input type="text" name="keyword" value="${keyword}">
                <button type="submit">검색</button>
            </form>
        </div>
        <table>
            <thead>
                <tr>
                    <td>번호</td>
                    <td>앨범명</td>
                    <td>앨범 발매일</td>
                    <td>소속사</td>
                    <td>발매사</td>
                    <td>앨범 청취연령</td>
                    <td>등록일</td>
                    <td>앨범표지</td>
                    <td>앨범 설명</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:if test="${albumList.size()==0}">
                    <tr>
                        <td>
                            <c:if test="${keyword != null}">검색어 "${keyword}" 에 해당하는</c:if>
                            앨범정보가 없습니다.
                        </td>
                    </tr>
                </c:if>
                <c:forEach items="${albumList}" var="item" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td>${item.ab_name}</td>
                        <td>
                            <fmt:formatDate value="${item.ab_re_dt}" pattern="yyyy년 MM월 dd일"/>
                        </td>
                        <td>${item.ent_name}</td>
                        <td>${item.rci_name}</td>
                        <td>
                            <c:if test="${item.ab_age == 0}">전연령</c:if>
                            <c:if test="${item.ab_age != 0}">${item.ab_age}세 이상</c:if>
                        </td>
                        <td>
                            <fmt:formatDate value="${item.ab_reg_dt}" pattern="yyyy년 MM월 dd일"/>
                        </td>
                        <td></td>
                        <td>
                            <form id="album_img_form">
                                <input type="file" name="file" id="ab_img_file" hidden accept = "image/gif, image/jpeg, image/png">
                            </form>
                            <td class="ab_covers">
                                <img src="/images/album_cover/${item.ab_img_file}" class="ab_detail_info" data-seq="${item.ab_seq}">     
                            </td>
                        </td>
                        <td>
                            <td class="album_text_area">
                                ${item.ab_acom_seq}
                            </td>
                        </td>
                        <td></td>
                        <td>
                            <a href="/album/modify?seq=${item.ab_seq}">
                                <i class="fas fa-info-circle"></i>
                                <span class="album_mod_btn">수정</span>
                            </a>
                        </td>
                        <td>
                            <a href="/album/list">
                                <i class="fas fa-trash-alt"></i>
                                <span class="album_del_btn" data-seq="${item.ab_seq}">삭제</span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="pager_area">
            <c:forEach begin="1" end="${pageCnt}" var="i">
                <a href="/album/list?page=${i}&keyword=${keyword}">${i}</a>
            </c:forEach>
        </div>
    </main>
</body>
</html>
