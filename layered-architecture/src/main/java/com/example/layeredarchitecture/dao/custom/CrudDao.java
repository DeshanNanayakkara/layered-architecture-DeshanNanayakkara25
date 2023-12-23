package com.example.layeredarchitecture.dao.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDao <T> {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean save(T dto) throws SQLException, ClassNotFoundException ;
    boolean update(T dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    void delete(String id) throws SQLException, ClassNotFoundException ;
    String genarateId() throws SQLException, ClassNotFoundException ;
    List<T> loadAllIds() throws SQLException, ClassNotFoundException;
    public T find(String code) throws SQLException, ClassNotFoundException;
    //public String generateID() throws SQLException, ClassNotFoundException;
}
