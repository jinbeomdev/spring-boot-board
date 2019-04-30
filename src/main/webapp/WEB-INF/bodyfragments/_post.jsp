<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8"%>
<c:if test="${post.author == pageContext.request.remoteUser}">
    <form action="/post/${post.id}/update" method="get">
        <button type="submit">수정</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</c:if>
<table>
    <tr>
        </td><input type="text" value="<c:out value="${post.title}"/>" name="title" maxlength="50" readonly/></td>
    </tr>
    <tr>
        <td>
            <textarea name="content" maxlength="2048" readonly><c:out value="${post.content}"/></textarea>
        </td>
    </tr>
</table>