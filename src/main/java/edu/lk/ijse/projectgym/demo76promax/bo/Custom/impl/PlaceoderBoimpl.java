package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.OrderDTO;
import edu.lk.ijse.projectgym.demo76promax.Dtos.OrderDetailsDTO;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.PlaceoderBo;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.OdersDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.OderDeatiles;
import edu.lk.ijse.projectgym.demo76promax.entity.Oders;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceoderBoimpl implements PlaceoderBo {
private OdersDAO oderDAO = DAOFactory.getInstance().getDao(DAOTipes.ODERS);


    @Override
    public boolean placeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {

        List<OderDeatiles>oderDeatilesList= new ArrayList<>();
        List<OrderDetailsDTO>cartlist =orderDTO.getCartList();
        for (OrderDetailsDTO oderOrderDetailsDTO : cartlist) {

            OderDeatiles oderDeatiles=new OderDeatiles(
                    oderOrderDetailsDTO.getOrderId(),
                    oderOrderDetailsDTO.getItemId(),
                    oderOrderDetailsDTO.getQty(),
                    oderOrderDetailsDTO.getTotal_price()
            );

            oderDeatilesList.add(oderDeatiles);
        }

        Oders oder=new Oders(
                orderDTO.getOrderId(),
                orderDTO.getCustomerId(),
                orderDTO.getDate(),
                oderDeatilesList
        );


      Boolean cach=oderDAO.placeOrder(oder);

       return cach;
    }

    @Override
    public String getNextOrderId() throws SQLException, ClassNotFoundException {

        String textid =oderDAO.getNextId();
        return textid;
    }

}
