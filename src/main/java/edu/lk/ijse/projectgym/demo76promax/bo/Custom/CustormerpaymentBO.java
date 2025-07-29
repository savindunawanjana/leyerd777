package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.memberPaymentDto;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;

public interface CustormerpaymentBO extends SuperBO {

    String save(memberPaymentDto customerPayment) throws ClassNotFoundException, SQLException;
    String deleteLowerPaymentIdsPerCustomer() throws ClassNotFoundException, SQLException;

}
