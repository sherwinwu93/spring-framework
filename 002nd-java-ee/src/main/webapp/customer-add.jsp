<%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>java-ee</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/customer/add" method="post">
    <table align="center" border="1">
        <tr>
            <td>客户名称: </td>
            <td><input type="text" name="name"></td>
            <td>负责人姓名: </td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td colspan="4"><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>
</body>
</html>
