package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.ManegeExsersaisDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.ManegeExercise;

import java.sql.SQLException;
import java.util.List;

public class ManegeexsersaisDAOImpl implements ManegeExsersaisDAO {

    @Override
    public List<ManegeExercise> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(ManegeExercise manegeExercise) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(ManegeExercise manegeExercise) throws ClassNotFoundException, SQLException {
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
