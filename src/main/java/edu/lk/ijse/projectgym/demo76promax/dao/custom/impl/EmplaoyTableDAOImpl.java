package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.EmplaoyTableDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeeTable;

import java.sql.SQLException;
import java.util.List;

public class EmplaoyTableDAOImpl implements EmplaoyTableDAO {

    @Override
    public List<EmployeeTable> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(EmployeeTable employeeTable) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(EmployeeTable employeeTable) throws ClassNotFoundException, SQLException {
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
