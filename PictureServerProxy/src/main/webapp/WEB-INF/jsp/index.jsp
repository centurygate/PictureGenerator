
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/26
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home page</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/fetchpic"  method="get">
    ChartID: <input type="text" name="chartid" value="1">
    <input type="submit" value="Submit">
</form>
</body>

</html>
