/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.PersonaDTO;
import java.sql.SQLException;

/**
 *
 * @author juanpablo
 * @param 
 */
    public interface PersonaImple extends CRUD<PersonaDTO> {
    
    PersonaDTO readNombres(String x) throws SQLException;
    
}
