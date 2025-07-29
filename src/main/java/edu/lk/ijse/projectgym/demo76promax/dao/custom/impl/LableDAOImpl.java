package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.LableDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Lable;

import java.sql.SQLException;
import java.util.List;

public class LableDAOImpl implements LableDAO {

    @Override
    public List<Lable> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(Lable lable) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(Lable lable) throws ClassNotFoundException, SQLException {
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
