<%-- 
    Document   : menuPersona
    Created on : May 18, 2019, 2:39:26 PM
    Author     : juanpablo
--%>

<%@page import="dto.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% PersonaDTO persona = (PersonaDTO) session.getAttribute("persona");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        <!--Fuente de google -->
        <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
        <title>JSP Page</title>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/validaciones.js"></script> 
         <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link href="dist/css/datepicker.min.css" rel="stylesheet" type="text/css">
        <script src="dist/js/datepicker.min.js"></script>

        <!-- Include English language -->
        <script src="dist/js/i18n/datepicker.en.js"></script>
        <script>   $( function() {
    $( "#datepicker" ).datepicker({
      showOtherMonths: true,
      selectOtherMonths: true
    });
  } );
</script>
        
    </head>
   
      <body>
        <div id="wrapper">
            <div id="menu">
                <ul>
                    <li class="current_page_item"><span><a href="index.html">Home</a></span></li>
                    <li><a href="">Registro Personas</a></li>			
                </ul>
            </div>
            <!-- Final del menu -->
            <div id="header">
                <div id="logo">
                    <h1><a href="#">Ingresar Personas</a></h1>
                </div>
            </div>
           
            <!-- Final del  #header -->
            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="content">
                            <div class="post">
                             


                                <form>                         
                                    <table>
                                         <tr>
                <th>Rut:</th>
                <td>
                    <input type="text" value="<%=persona != null ? persona.getRut() : ""%>" maxlength="15" size="15" name="txtRut" id="txtRut" <%=persona != null ? "disabled" : ""%>

                <th>&nbsp;-</th>
                <td>
                    <input type="text" value="<%=persona != null ? persona.getRutDv() : ""%>" maxlength="1" size="2" name="txtRutDv" id="txtRutDv" <%=persona != null ? " disabled" : ""%>>
                </td>
                </td>
            </tr>
                                        <br>
                                      <tr>
                <th>Nombres:</th>
                <td>
                    <input type="text" value="<%=persona != null ? persona.getNombres() : ""%>" maxlength="80" size="15" name="txtNombres" id="txtNombres">
                </td>
            </tr>
                                        <br>
                                    <tr>
                <th>Apellidos:</th>
                <td>
                    <input type="text" value="<%=persona != null ? persona.getApellidos() : ""%>" maxlength="80" size="15" name="txtApellidos" id="txtApellidos">
                </td>
            </tr>
                                        <br>
                                      <tr>
                <th>Correo:</th>
                <td>
                    <input type="text" value="<%=persona != null ? persona.getCorreo() : ""%>" maxlength="50" size="15" name="txtCorreo" id="txtCorreo">
                </td>
            </tr>
                                        <br>

                                      <tr>
                <th>Date:</th>
                <td>
                    <input type="text" value="<%=persona != null ? persona.getFechaNacimiento(): ""%>" id="datepicker" name="datepicker" size="15">
                </td>
            </tr>
            <tr>
                <td>
                    
                    </td>
                
            </tr>
            
                                        <br>
                                       <tr>
                <th>Direccion</th>
                <td>
                    <input type="text" value="<%=persona != null ? persona.getDireccion() : ""%>" maxlength="50" size="15" name="txtDireccion" id="txtDireccion">
                </td>
            </tr>
                                        <br>
                                   <tr>
                <td>
                    <input type="button" value="<%= persona == null ? "Grabar" : "Editar"%>" onclick="grabar()">
                    <% if (persona != null) {%>
                    <input type="button" value="Eliminar" onclick="eliminar()" 
                           <%}%>
                </td>
            </tr>
                                        <br>
                                      
                                       
                                    </table>
                                </form>
                            </div>
                         
            <!-- final del  #footer -->
        </div>
    
   
</html>

