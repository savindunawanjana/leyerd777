package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.ItemDTO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.ItemDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.SQLUtil;
import edu.lk.ijse.projectgym.demo76promax.entity.Items;
import edu.lk.ijse.projectgym.demo76promax.entity.OderDeatiles;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public List<Items> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM items";
        List<Items> itemList = new ArrayList<>();
        try (Connection con = Dbconnection.getObject().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                itemList.add(new Items(
                        rs.getString("item_id"),
                        rs.getString("name"),
                        rs.getInt("qty"),
                        BigDecimal.valueOf(rs.getDouble("unit_price")),
                        rs.getString("supplier_id")
                ));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return itemList;
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM items WHERE item_id = ?";
        try (Connection con = Dbconnection.getObject().getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, id);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean update(Items items) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE items SET name = ?,qty = ?, unit_price = ?, supplier_id = ? WHERE item_id = ?";
        try (Connection con = Dbconnection.getObject().getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, items.getItemName());
            pst.setInt(2, items.getItemqty());
            pst.setBigDecimal(3, items.getUnitPrice());
            pst.setString(4, items.getSupplierId());
            pst.setString(5, items.getItemId());
            return pst.executeUpdate() > 0;
        }
    }

    @Override
    public Boolean save(Items items) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO items (item_id, name,qty, unit_price, supplier_id) VALUES (?, ?, ?, ?, ?)";
        try {
                Connection con = Dbconnection.getObject().getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, items.getItemId());
            pst.setString(2, items.getItemName());
            pst.setInt(3, items.getItemqty());
            pst.setBigDecimal(4, items.getUnitPrice());
            pst.setString(5, items.getSupplierId());
            return pst.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
    public ArrayList<String> getAllItemIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute(
                "select item_id from items"
        );
        ArrayList<String> list = new ArrayList<>();
        while (rst.next()) {
            String id = rst.getString(1);
            list.add(id);
        }
        return list;
    }

    @Override
    public Items findById(String itemId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute(
                "select * from items where item_id=?",
                itemId
        );

        if (rst.next()) {
            return new Items(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    BigDecimal.valueOf(rst.getDouble(4)),
                    rst.getString(5)
            );
        }
        return null;
    }

    @Override
    public boolean reduceQty(OderDeatiles orderDetailsentyty) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(
                "update items set qty = qty-? where item_id=?",
                orderDetailsentyty.getQuantity(),
                orderDetailsentyty.getItemId()
        );
    }
}
