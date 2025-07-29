package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.memberPaymentDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.CustormerpaymentBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CusormerPaymentsDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.CustomerPayment;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class CustormerpaymentBOImpl implements CustormerpaymentBO {
    private CusormerPaymentsDAO cusormerPaymentsDAO= DAOFactory.getInstance().getDao(DAOTipes.CUSTOMERPAYMENT);

    @Override
    public String save(memberPaymentDto memberPaymentDto) throws ClassNotFoundException, SQLException {


        Date date1 = Date.valueOf(memberPaymentDto.getExpire_date());
        BigDecimal amount = BigDecimal.valueOf(memberPaymentDto.getPayment_amount());
        Date date2 = Date.valueOf(memberPaymentDto.getPayment_date());

      CustomerPayment customerPayment=new CustomerPayment(

              7,
              memberPaymentDto.getCustomer_id(),
              date1,
              memberPaymentDto.getValid_number_of_month(),
              memberPaymentDto.getSystem_user_role(),
              date2,
              amount

      );

        Boolean cach =cusormerPaymentsDAO.save(customerPayment);
        return  cach==true ? "save sucsessfuli" :"save Unsucsessfuli";


    }

    @Override
    public String deleteLowerPaymentIdsPerCustomer() throws ClassNotFoundException, SQLException {

      String cach  = cusormerPaymentsDAO.deleteLowerPaymentIdsPerCustomer();

      return cach;

    }
}
