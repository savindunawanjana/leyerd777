package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.memberPaymentDto;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDetailsMenuBO extends SuperBO {

List<memberPaymentDto> getAllpaymentDeatiles() throws ClassNotFoundException, SQLException;

}
