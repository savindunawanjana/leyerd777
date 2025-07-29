package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.ComanpasswordDao;
import edu.lk.ijse.projectgym.demo76promax.entity.CommonPassword;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ComanpassworDAOimpl implements ComanpasswordDao {

    @Override
    public List<CommonPassword> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(CommonPassword commonPassword) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(CommonPassword commonPassword) throws ClassNotFoundException, SQLException {
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
    public String setComanPassword(String password) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE coman_password SET password = ? WHERE id = 1";

        try (Connection con = Dbconnection.getObject().getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, password);
            int result = pst.executeUpdate();

            return result > 0 ? "Update successful" : "Update not successful";
        }

    }

    @Override
    public String getComanPassword(String textfild) throws SQLException, ClassNotFoundException {
        String sql = "SELECT password FROM coman_password WHERE id = 1";

        try (Connection con = Dbconnection.getObject().getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rst = pst.executeQuery()) {

            if (rst.next()) {
                return rst.getString("password");
            }
            return null;  // or "" depending on what you prefer
        }

    }

    @Override
    public ObservableList<CommonPassword> getComanPasswordFromDatabases() throws SQLException, ClassNotFoundException {
        ObservableList<CommonPassword> list = FXCollections.observableArrayList();

        String sql = "SELECT * FROM coman_password";

        try (Connection con = Dbconnection.getObject().getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rst = pst.executeQuery()) {

            while (rst.next()) {
                CommonPassword obj = new CommonPassword();
                obj.setPassword(rst.getString("password"));
                list.add(obj);
            }
        }

        return list;
    }


}
