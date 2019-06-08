/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author juanpablo
 */
public interface CRUD <POJO>{
    
    boolean create(POJO x) throws SQLException;

    POJO read(Object x) throws SQLException;

    boolean delete(Object x) throws SQLException;

    boolean update(POJO x) throws SQLException;

    List<POJO> readAll() throws SQLException;
    
}
