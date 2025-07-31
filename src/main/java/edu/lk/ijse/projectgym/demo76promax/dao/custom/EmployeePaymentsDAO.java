package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.employePaymentDto;
import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeePayments;

import java.sql.SQLException;

public interface EmployeePaymentsDAO extends CrudDAO<EmployeePayments> {

    boolean saveMethod1(EmployeePayments entyty) throws SQLException, ClassNotFoundException;
    String searchEmployeePaymentsById(String employeeId) throws SQLException, ClassNotFoundException;

}
