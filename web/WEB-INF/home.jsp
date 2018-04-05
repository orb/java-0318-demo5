<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A login example</title>
    </head>
    <body>
        <h1>I wonder if I'm logged in</h1>

        <c:choose>
            <c:when test="${user != null}">
                <h2>Logged in as <b><c:out value="${user}"></c:out></b></h2>
                 
                <a href="/letmein/secret">Find out the secret</a>
                
                <a href="/letmein/logout">Logout</a>
            </c:when>
                
            <c:otherwise>
                <h2>Not logged in!</h2>
                <form method="POST" action="/letmein/">
                    <input type="submit" value="Login" />
                </form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
