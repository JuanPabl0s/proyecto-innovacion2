/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author juanpablo
 */
public class PersonaDTO {

    private String rut;
    private String rutDv;
    private String nombres;
    private String apellidos;
    private String correo;
    private String fechaNacimiento;
    private String direccion;

    

    public PersonaDTO(String rut, String rutDv, String nombres, String apellidos, String correo, String fechaNacimiento, String direccion) {
        this.rut = rut;
        this.rutDv = rutDv;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }
    
    public PersonaDTO() {
        
        this.rut = "";
        this.rutDv = "";
        this.nombres = "";
        this.apellidos = "";
        this.correo = "";
        this.fechaNacimiento = "";
        this.direccion = "";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRutDv() {
        return rutDv;
    }

    public void setRutDv(String rutDv) {
        this.rutDv = rutDv;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" + "rut=" + rut + ", rutDv=" + rutDv + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }
    
    

}
