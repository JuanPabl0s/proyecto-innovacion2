<%-- 
    Document   : error
    Created on : May 18, 2019, 2:38:25 PM
    Author     : juanpablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String error = (String) session.getAttribute("error");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        <!--Fuente de google -->
        <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Se ha Detectado un error <%=error%> <br> Revisar Codigo</h1>
    </body>
</html>
