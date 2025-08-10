package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.ItemDTO;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {

    ItemDTO findById(String itemId) throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllItemIds() throws SQLException, ClassNotFoundException;
}
