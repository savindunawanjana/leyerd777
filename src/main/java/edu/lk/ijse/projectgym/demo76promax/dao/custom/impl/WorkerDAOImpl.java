package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.WorkerDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Worker;

import java.sql.SQLException;
import java.util.List;

public class WorkerDAOImpl implements WorkerDAO {

    @Override
    public List<Worker> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(Worker worker) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(Worker worker) throws ClassNotFoundException, SQLException {
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
