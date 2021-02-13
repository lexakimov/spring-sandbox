<%--
  Created by IntelliJ IDEA.
  User: akimov
  Date: 25.11.2020
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>

</head>
<body>
This is a secured view!<br>
<pre>
    <%= request.getUserPrincipal().toString()
            .substring(88)
            .replaceAll("; ", "\n\r") %>
</pre>

</body>
</html>
