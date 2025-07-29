package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.CustomerPayment;

import java.sql.SQLException;

public interface CusormerPaymentsDAO  extends CrudDAO<CustomerPayment> {
    String deleteLowerPaymentIdsPerCustomer()throws ClassNotFoundException, SQLException;
}
