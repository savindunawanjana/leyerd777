package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.DeleteworkerDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.DeleteWorker;

import java.sql.SQLException;
import java.util.List;

public class DeleteworkerDAOImpl implements DeleteworkerDAO {


    @Override
    public List<DeleteWorker> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(DeleteWorker deleteWorker) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(DeleteWorker deleteWorker) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return null;
    }
}
