package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.SuplayersDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Suppliers;

import java.sql.SQLException;
import java.util.List;

public class SuplayersDAOImpl implements SuplayersDAO {

    @Override
    public List<Suppliers> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(Suppliers suppliers) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(Suppliers suppliers) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return "";
    }
}
