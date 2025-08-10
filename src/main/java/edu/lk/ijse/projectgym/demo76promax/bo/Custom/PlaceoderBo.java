package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.OrderDTO;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;

public interface PlaceoderBo extends SuperBO {

    boolean placeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
    String getNextOrderId() throws SQLException, ClassNotFoundException;


}
