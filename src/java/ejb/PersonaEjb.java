/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.PersonaDAO;
import dto.PersonaDTO;
import java.sql.SQLException;
import java.util.List;
import org.json.simple.JSONObject;
import util.Utilitario;

/**
 *
 * @author juanpablo
 */
public class PersonaEjb {
    

    public PersonaDTO traePersonaRut(String rut) throws SQLException, Exception {
        PersonaDAO dao = new PersonaDAO();
        PersonaDTO persona = dao.read(rut);

        if (persona == null) {
            throw new Exception("No se encontro informacion con el rut ingresado");
        }
        return persona;
    }

    public String validarPersona(String rut, String rutDv, String nombres, String apellidos, String correo, String fechaNacimiento,String direccion) {
       String response = "";     
        try {
            
             JSONObject json = new JSONObject();
            
        int respuesta = 0;
        String mensaje = "";

        if (rut.equalsIgnoreCase("") || Utilitario.validaRut(rut)) {
            respuesta = 1;
            mensaje += "Rut validado \n";
        }
        
         if (rutDv.equalsIgnoreCase("") || Utilitario.validaRut(rut)) {
            respuesta = 1;
            mensaje += "Rut validado \n";
        }

        if (nombres.equalsIgnoreCase("")) {
            respuesta = 1;
            mensaje += "Nombre invalido \n";
        }

        if (apellidos.equalsIgnoreCase("")) {
            respuesta = 1;
            mensaje += "Apellido invalido \n";
        }

       // if (!Utilitario.isNumeric(anio)) {
       //     respuesta = 1;
       //     mensaje += "Año invalido \n";
       // }

        if (correo.equalsIgnoreCase("")) {
            respuesta = 1;
            mensaje += "correo invalido \n";
        }
        if (fechaNacimiento.equalsIgnoreCase("")) {
            respuesta = 1;
            mensaje += "Fecha invalida \n";
        }
        if (direccion.equalsIgnoreCase("")) {
            respuesta = 1;
            mensaje += "Direccion invalida \n";
        }



        json.put("respuesta", respuesta);
        json.put("mensaje", mensaje);

        
        response =   json.toString();
        }
            
        catch (Exception ex) 
        {
            System.out.println("Error"+ex); 
        }
        return response; 
    
    }


        

    public String grabarPersona(PersonaDTO persona) throws SQLException {
        PersonaDAO dao = new PersonaDAO();
        JSONObject json = new JSONObject();

        if (dao.read(persona.getRut()) == null) {
            if (dao.create(persona)) {
                json.put("respuesta", 0);
                json.put("mensaje", "Persona almacenada correctamente");
            } else {
                json.put("respuesta", 1);
                json.put("mensaje", "No se pudo guardar la Persona");
            }
        } else if (dao.update(persona)) {
            json.put("respuesta", 0);
            json.put("mensaje", "Persona Actualizado correctamente");
        } else {
            json.put("respuesta", 1);
            json.put("mensaje", "No se pudo almacenar Persona");
        }

        return json.toString();
    }

    public String eliminarPersona(String rut) throws SQLException {

        PersonaDAO dao = new PersonaDAO();
        JSONObject json = new JSONObject();

        if (dao.delete(rut)) {
            json.put("respuesta", 0);
            json.put("mensaje", "Persona eliminada correctamente");
        } else {
            json.put("respuesta", 1);
            json.put("mensaje", "No se pudo eliminar personas");
        }
        
        return json.toString();
    }

    public String traerPersonas() throws SQLException {
          PersonaDAO dao = new PersonaDAO();
        List<PersonaDTO> personas = dao.readAll();
        StringBuilder str = new StringBuilder();

        str.append("<table border=1>");
        str.append("<tr>");
        str.append("<th>").append("Rut").append("</th>");
        str.append("<th>").append("RutDv").append("</th>");
        str.append("<th>").append("Nombres").append("</th>");
        str.append("<th>").append("Apellidos").append("</th>");
        str.append("<th>").append("Correo").append("</th>");
        str.append("<th>").append("FechaNacimiento").append("</th>");
        str.append("<th>").append("Direccion").append("</th>");
        str.append("</tr>");
        for (PersonaDTO x : personas) {
            str.append("<tr>");
            str.append("<td>").append(x.getRut()).append("</td>");
            str.append("<td>").append(x.getRutDv()).append("</td>");
            str.append("<td>").append(x.getNombres()).append("</td>");
            str.append("<td>").append(x.getApellidos()).append("</td>");
            str.append("<td>").append(x.getCorreo()).append("</td>");
            str.append("<td>").append(x.getFechaNacimiento()).append("</td>");
            str.append("<td>").append(x.getDireccion()).append("</td>");
            str.append("<td>");
            str.append("<a href='persona?menu=consultar&rut=").append(x.getRut()).append("'>Actualizar/Eliminar</a>");
           
            str.append("</td>");
            str.append("</tr>");
        }

        return str.toString();
    }
    
}
