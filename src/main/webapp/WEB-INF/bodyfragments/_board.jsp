<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8"%>
<h2> 게시판 목록 </h2>
<p>${pageContext.request.remoteUser}님 환영합니다!</p>
<form action="/logout" method="post">
    <button type="submit">logout</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<button onclick="location.href='/write';">글쓰기</button>
<table>
    <thead>
        <tr>
            <th>게시글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>최종수정일</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td><c:out value="${post.id}"/></td>
                <td><a href = "/post/<c:out value="${post.id}"/>"><c:out value="${post.title}"/></td></a>
                <td><c:out value="${post.author}"/></td>
                <td><c:out value="${post.modifiedDate}"/></td>
            </tr>
        </c:forEach>
     </tbody>
</table>