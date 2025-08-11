package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.ItemDTO;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.ItemBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.ItemDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.Items;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean saveItem(ItemDTO item) throws ClassNotFoundException,SQLException {

        Items items=new Items(

                item.getItemId(),
                item.getName(),
                item.getQuantity(),
                BigDecimal.valueOf(item.getUnitPrice()),
                item.getSupplier_id()
        );

        return itemDAO.save(items);



    }

    @Override
    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {

        Items items=new Items(
                item.getItemId(),
                item.getName(),
                item.getQuantity(),
                BigDecimal.valueOf(item.getUnitPrice()),
                item.getSupplier_id()
        );

        return itemDAO.update(items);

    }

    @Override
    public boolean deleteItem(String itemId) throws SQLException, ClassNotFoundException {

        return itemDAO.delete(itemId);

    }

    @Override
    public List<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {

        List<Items>entytylist =itemDAO.getAll();
        List<ItemDTO> itemDTOList=new ArrayList<>();

        for(Items items:entytylist){

            ItemDTO itemDTO=new ItemDTO(
                    items.getItemId(),
                    items.getItemName(),
                    items.getItemqty(),
                    items.getUnitPrice().doubleValue(),
                    items.getSupplierId()

            );
            itemDTOList.add(itemDTO);
        }




       return itemDTOList;
    }
}
