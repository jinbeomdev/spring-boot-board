<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8"%>
<form action ="/post/write?${_csrf.parameterName}=${_csrf.token}", id="writeForm">
    <table>
        <tr>
            </td><input type="text" placeholder="글 제목" name="title" maxlength="50"/></td>
        </tr>
        <tr>
            <td><textarea placeholder="글 내용" name="content" maxlength="2048"></textarea></td>
        </tr>
    </table>
    <input type="hidden" name="author" value=${pageContext.request.remoteUser} />
    <input type="submit" value="글쓰기" />
</form>