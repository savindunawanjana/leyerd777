package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.OrderDTO;
//import edu.lk.ijse.projectgym.demo76promax.Modal.OrderDetailsModel;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.OderdeatilesDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.OdersDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.dao.util.SQLUtil;
import edu.lk.ijse.projectgym.demo76promax.entity.Oders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OdersDAOImpl implements OdersDAO {
//    private final OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
    private OderdeatilesDAO oderdeatilesDAO = DAOFactory.getInstance().getDao(DAOTipes.ODERDEATILES);
    @Override
    public List<Oders> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(Oders oders) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(Oders oders) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        ResultSet resultSet = SQLUtil.execute(
                "select order_id from orders order by order_id desc limit 1"
        );

        char tableChar = 'O';
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String lastIdNUmberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNUmberString);
            int nextIdNumber = lastIdNumber + 1;
            String nextIdString = String.format(tableChar + "%03d", nextIdNumber);
            return nextIdString;
        }
        return tableChar + "001";
    }

    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public boolean placeOrder(Oders orderentyty) throws SQLException, ClassNotFoundException {
        Connection connection = Dbconnection.getObject().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean isSave = SQLUtil.execute(
                    "insert into orders values (?,?,?)",
                    orderentyty.getOrderId(),
                    orderentyty.getCustomerId(),
                    orderentyty.getOderDate()
            );
            if (isSave) {
                boolean isDetailsSaved = oderdeatilesDAO.saveOderdeatilesList(orderentyty.getCartList());
                if (isDetailsSaved) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }


}
