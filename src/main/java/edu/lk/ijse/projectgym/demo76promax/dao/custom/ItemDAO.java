package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.ItemDTO;
import edu.lk.ijse.projectgym.demo76promax.Dtos.OrderDetailsDTO;
import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Items;
import edu.lk.ijse.projectgym.demo76promax.entity.OderDeatiles;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO <Items>{
    ArrayList<String> getAllItemIds() throws SQLException, ClassNotFoundException;
    Items findById(String itemId) throws SQLException, ClassNotFoundException;
    boolean reduceQty(OderDeatiles orderDetailsentyty) throws SQLException, ClassNotFoundException;
}
