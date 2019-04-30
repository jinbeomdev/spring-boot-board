<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="title" /></title>
    <link rel="stylesheet" href="/static/css/lib/bootstrap.min.css">
</head>
<body>
    <table width="100%">
        <tr>
            <td colspan="2">
                <tiles:insertAttribute name="header" />
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap">
                 <tiles:insertAttribute name="menu" />
             </td>
            <td width="80%">
                 <tiles:insertAttribute name="body" />
             </td>
        </tr>
        <tr>
            <td colspan="2">
                 <tiles:insertAttribute name="footer" />
            </td>
        </tr>
    </table>

    <script src="/static/js/lib/jquery-3.4.0.min.js"></script>
    <script src="/static/js/lib/bootstrap.min.js"></script>

    <tiles:importAttribute name="js"/>
    <c:forEach var="item" items="${js}">
    <script src="<c:url value="${item}"/>"></script>
    </c:forEach>
</body>
</html>