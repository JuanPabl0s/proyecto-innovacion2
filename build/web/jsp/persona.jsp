<%-- 
    Document   : persona
    Created on : May 18, 2019, 2:36:15 PM
    Author     : juanpablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String personas = (String)session.getAttribute("personas");%>
<!DOCTYPE html>
<html>
    <head>
           <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        <!--Fuente de google -->
        <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-3.3.1.min.js"> </script>
        <script src="js/validaciones.js"> </script> 
    </head>
    
    
    
    
    
    <body>
        
        <h1>Personas</h1> 
        <h1><a href="persona?menu=crear">Ingresar Persona</a></h1>
        <br>
        <br>
        <h1>Listado de Personas</h1>
        <div style="text-align: center">            
            <%=personas%>
        </div>
    </body>
</html>
