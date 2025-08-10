package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.ItemDTO;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.ItemBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.ItemDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.Items;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOimpl implements ItemBO {

    private ItemDAO itemDAO = DAOFactory.getInstance().getDao(DAOTipes.ITEMS);

    @Override
    public ItemDTO findById(String itemId) throws SQLException, ClassNotFoundException {
        Items items=itemDAO.findById(itemId);
        ItemDTO itemDTO=new ItemDTO(

                items.getItemId(),
                items.getItemName(),
                items.getItemqty(),
                items.getUnitPrice().doubleValue(),
                items.getSupplierId()
        );
        return itemDTO;
    }

    @Override
    public ArrayList<String> getAllItemIds() throws SQLException, ClassNotFoundException {
         ArrayList<String>idList=itemDAO.getAllItemIds();
        return idList;
    }
}
