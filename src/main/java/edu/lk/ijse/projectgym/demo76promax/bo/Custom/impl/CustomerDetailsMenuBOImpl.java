package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.memberPaymentDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.CustomerDetailsMenuBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CusormerPaymentsDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.CustomerPayment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetailsMenuBOImpl implements CustomerDetailsMenuBO {

    private CusormerPaymentsDAO cusormerPaymentsDAO = DAOFactory.getInstance().getDao(DAOTipes.CUSTOMERPAYMENT);

    @Override
    public List<memberPaymentDto> getAllpaymentDeatiles() throws ClassNotFoundException, SQLException {

        List<CustomerPayment> memberPaymententyty = cusormerPaymentsDAO.getAll();
        List<memberPaymentDto> memberPaymentDtoList =new ArrayList<>();

        for (CustomerPayment customerPayment : memberPaymententyty) {
            memberPaymentDto memberPaymentDto= new memberPaymentDto(

                    String.valueOf(customerPayment.getPaymentId()),
                    customerPayment.getCustomerId(),
                    String.valueOf( customerPayment.getExpayerDate()),
                    customerPayment.getValidNomberOfMonths(),
                    customerPayment.getSystemUserRoll(),
                    String.valueOf(customerPayment.getPaymentDate()),
                    customerPayment.getPaymentAmount().doubleValue()
            );

            memberPaymentDtoList.add(memberPaymentDto);

        }

        return memberPaymentDtoList;

    }
}
