package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.employePaymentDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.EmployeePaymentmanegementBO;
import edu.lk.ijse.projectgym.demo76promax.bo.util.EntityDTOConverter;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.EmployeePaymentsDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeePayments;

import java.sql.SQLException;


public class EmployeePaymentmanegementBOimpl implements EmployeePaymentmanegementBO {
    private EmployeePaymentsDAO employeePaymentsDAO = DAOFactory.getInstance().getDao(DAOTipes.EMPLOYEEPAYMENTS);
private EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public String saveMethod1(employePaymentDto dto) throws SQLException, ClassNotFoundException {

      EmployeePayments employeePayments = converter.getemployeepaymentEntyty(dto);
         Boolean rsp = employeePaymentsDAO.saveMethod1(employeePayments);

         return rsp==true ? "saved sucsess fully" : "saved Unsucsess fully";
    }

    @Override
    public String searchEmployeePaymentsById(String employeeId) throws SQLException, ClassNotFoundException {
        String id = employeePaymentsDAO.searchEmployeePaymentsById(employeeId);
        return id;
    }
}
