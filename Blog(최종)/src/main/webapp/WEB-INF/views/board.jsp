<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jstlHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
   
<meta charset="UTF-8">
<title>손준 블로그</title>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
</head>
<body>
<p>환영합니다 ${sessionScope.loginUser.nickname }님 <a href="/Blog/logout">로그아웃</a></p>
<p>손준 블로그</p>
<div>게시글 리스트</div>
<table>
<thead><tr>
<td>등록번호</td>
<td>제목</td>
<td>조회수</td>
<td>좋아요</td>
<td>글 작성 날짜</td>
</tr></thead>

<c:forEach var="l" items="${list}">
<fmt:formatDate value="${l.create_time}" pattern="yyyy-MM-dd HH:MM:ss" var="dateFormat_cr"/>
<tr>
<td>${l.id}</td>
<td><a href="/Blog/detailDocument?id=${l.id }">${l.subject }</a></td>
<td>${l.views }</td>
<td>${l.likes }</td>
<td>${dateFormat_cr }</td>
</tr>
</c:forEach>
</table>
<div> <a href="/Blog/writeBoard">글 작성하기</a></div>
</body>
</html>