<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page session="true"%>
<html>
<head>
<title>login</title>
</head>
<body>
    <c:if test="${param.error != null}">
        <div>
            <p>아이디 또는 비밀번호가 틀렸습니다</p>
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div>
            <p>성공적으로 로그아웃이 되었습니다</p>
        </div>
    </c:if>
    <form action="/login" method='POST'>
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='userId'></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                  value="submit" /></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</body>
</html>