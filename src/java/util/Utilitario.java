/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author juanpablo
 */
public class Utilitario {
    
    private Utilitario() {

    }

    public static String noNull(String valor) {
        return valor == null ? "" : valor;
    }

    public static int noNull(Integer valor) {
        return valor == null ? 0 : valor;
    }

    public static boolean isNumeric(String valor) {
        try {
            int x = Integer.parseInt(Utilitario.noNull(valor));
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
    
    public static boolean isLetra(String valor){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÑ";
        
        return letras.contains(valor.toUpperCase());
        
        
    }
    
    public static boolean isLetra(Character valor){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÑ";
        
        return letras.contains(valor.toString());

    }

    public static boolean validaRut(String rut) {
        Pattern p = Pattern.compile("/^[A-Z]{3}\\d{3}$/");
        Matcher m = p.matcher(rut);
        
        return m.matches();
        
    }
    
}
