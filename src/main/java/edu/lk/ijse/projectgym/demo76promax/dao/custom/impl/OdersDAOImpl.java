package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.OdersDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Oders;

import java.sql.SQLException;
import java.util.List;

public class OdersDAOImpl implements OdersDAO {

    @Override
    public boolean placeOrder(Oders oders) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public List<Oders> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(Oders oders) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(Oders oders) throws ClassNotFoundException, SQLException {
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
