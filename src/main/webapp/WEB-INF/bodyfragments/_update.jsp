<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8"%>
<form action ="/post/${post.id}/update?${_csrf.parameterName}=${_csrf.token}", id="writeForm">
    <table>
        <tr>
            </td><input type="text" value="${post.title}" name="title" maxlength="50"/></td>
        </tr>
        <tr>
            <td><textarea name="content" maxlength="2048">${post.content}</textarea></td>
        </tr>
    </table>
    <input type="hidden" name="author" value=${pageContext.request.remoteUser} />
    <input type="submit" value="글쓰기" />
</form>