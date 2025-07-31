package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.employePaymentDto;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;

public interface EmployeePaymentmanegementBO extends SuperBO {

    String saveMethod1(employePaymentDto dto) throws SQLException, ClassNotFoundException;
    String searchEmployeePaymentsById(String employeeId) throws SQLException, ClassNotFoundException;


}
