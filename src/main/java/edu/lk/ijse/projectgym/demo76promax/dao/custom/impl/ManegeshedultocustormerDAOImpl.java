package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.ManegeshedultocustormerDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.ManegeShedulToCustormer;

import java.sql.SQLException;
import java.util.List;

public class ManegeshedultocustormerDAOImpl implements ManegeshedultocustormerDAO {

    @Override
    public List<ManegeShedulToCustormer> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(ManegeShedulToCustormer manegeShedulToCustormer) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(ManegeShedulToCustormer manegeShedulToCustormer) throws ClassNotFoundException, SQLException {
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
