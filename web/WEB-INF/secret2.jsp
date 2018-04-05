<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Secret, the last</title>
    </head>
    <body>
        The other secret is <b><c:out value="${theSecret}"></c:out></b>.
              
        <a href="/letmein">back</a>
    </body>
</html>