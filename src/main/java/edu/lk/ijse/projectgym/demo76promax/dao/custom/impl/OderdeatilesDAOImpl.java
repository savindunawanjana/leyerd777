package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.OrderDetailsDTO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.ItemDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.OderdeatilesDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.dao.util.SQLUtil;
import edu.lk.ijse.projectgym.demo76promax.entity.OderDeatiles;

import java.sql.SQLException;
import java.util.List;

public class OderdeatilesDAOImpl implements OderdeatilesDAO {

    ItemDAO itemDAO = DAOFactory.getInstance().getDao(DAOTipes.ITEMS);
    @Override
    public List<OderDeatiles> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(OderDeatiles oderDeatiles) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(OderDeatiles oderDeatiles) throws ClassNotFoundException, SQLException {
        return null;
    }


    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public Boolean saveOderdeatilesList(List<OderDeatiles> cartList) throws ClassNotFoundException, SQLException {

        for (OderDeatiles oderDeatiles : cartList) {
            boolean isDetailsSaved = saveOrderDetails(oderDeatiles);
            if (!isDetailsSaved) {
                return false;
            }
            boolean isUpdated = itemDAO.reduceQty(oderDeatiles);
            if (!isUpdated) {
                return false;

            }

        }
        return true;
    }

    @Override
    public boolean saveOrderDetails(OderDeatiles orderentyty) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(
                "insert into order_details values (?,?,?,?)",
                orderentyty.getOrderId(),
                orderentyty.getItemId(),
                orderentyty.getQuantity(),
                orderentyty.getPrice()
        );
    }
}
