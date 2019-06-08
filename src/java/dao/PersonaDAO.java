/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.PersonaDTO;
import interfaces.PersonaImple;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanpablo
 */
public class PersonaDAO implements PersonaImple{
    
    
    private static final String SQL_INSERT = "INSERT INTO persona (rut, rutDv, nombres, apellidos, correo, fechaNacimiento, direccion) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_READ = "SELECT RUT,rutDv , NOMBRES,APELLIDOS,CORREO,FECHANACIMIENTO,DIRECCION FROM PERSONA WHERE RUT = ?";
    private static final String SQL_READALL = "SELECT RUT,RUTDV,NOMBRES,APELLIDOS,CORREO,FECHANACIMIENTO,DIRECCION FROM PERSONA";
    private static final String SQL_UPDATE = "UPDATE persona SET nombres = ?, apellidos = ?,correo = ?, fechaNacimiento = ?, direccion = ? WHERE rut = ? ";
    private static final String SQL_DELETE = "DELETE FROM PERSONA WHERE RUT=?";

    private static final Conexion cnn = Conexion.saberEstado();



    @Override
    public boolean create(PersonaDTO x) throws SQLException {
        try (PreparedStatement ps = cnn.getConn().prepareStatement(SQL_INSERT);) {
            ps.setString(1, x.getRut());
            ps.setString(2, x.getRutDv());
            ps.setString(3, x.getNombres());
            ps.setString(4, x.getApellidos());
            ps.setString(5, x.getCorreo());
            ps.setString(6, x.getFechaNacimiento());
            ps.setString(7, x.getDireccion());
           

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public PersonaDTO read(Object x) throws SQLException {
        ResultSet res;
        PersonaDTO persona = null;
        try (PreparedStatement ps = cnn.getConn().prepareStatement(SQL_READ);) {
            ps.setString(1, x.toString());

            res = ps.executeQuery();

            if (res.next()) {
                persona = new PersonaDTO();
                persona.setRut(res.getString("RUT"));
                persona.setRutDv(res.getString("RUTDV"));
                persona.setNombres(res.getString("NOMBRES"));
                persona.setApellidos(res.getString("APELLIDOS"));
                persona.setCorreo(res.getString("CORREO"));
                persona.setFechaNacimiento(res.getString("FECHANACIMIENTO"));
                persona.setDireccion(res.getString("DIRECCION"));
                
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            cnn.cerrarConexion();
        }
        return persona;
    }

    @Override
    public boolean delete(Object x) throws SQLException {
        try (PreparedStatement ps = cnn.getConn().prepareStatement(SQL_DELETE);) {
            ps.setString(1, x.toString());
            if (ps.executeUpdate() > 0) {
                return true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    
    }
    @Override
    public boolean update(PersonaDTO x) throws SQLException {
        try (PreparedStatement ps = cnn.getConn().prepareStatement(SQL_UPDATE);) {
            
            
            ps.setString(1, x.getNombres());
            ps.setString(2, x.getApellidos());
            ps.setString(3, x.getCorreo());
            ps.setString(4, x.getFechaNacimiento());
            ps.setString(5, x.getDireccion());
            ps.setString(6, x.getRut());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }  

    @Override
    public List<PersonaDTO> readAll() throws SQLException {
        ResultSet res;
        PersonaDTO persona = null;
        List<PersonaDTO> lista = new ArrayList<>();

        try (PreparedStatement ps = cnn.getConn().prepareStatement(SQL_READALL);) {
            res = ps.executeQuery();

            while (res.next()) {
                persona = new PersonaDTO();
                persona.setRut(res.getString("RUT"));
                persona.setRutDv(res.getString("RUTDV"));
                persona.setNombres(res.getString("NOMBRES"));
                persona.setApellidos(res.getString("APELLIDOS"));
                persona.setCorreo(res.getString("CORREO"));
                persona.setFechaNacimiento(res.getString("FECHANACIMIENTO"));
                persona.setDireccion(res.getString("DIRECCION"));
                
                lista.add(persona);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            cnn.cerrarConexion();
        }
        return lista;
    }

    @Override
    public PersonaDTO readNombres(String x) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
