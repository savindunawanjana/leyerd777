package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.EmployeePaymentsDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeePayments;

import java.sql.SQLException;
import java.util.List;

public class EmployeePaymentsDAOImpl implements EmployeePaymentsDAO {

    @Override
    public List<EmployeePayments> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(EmployeePayments employeePayments) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(EmployeePayments employeePayments) throws ClassNotFoundException, SQLException {
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
