package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.LableDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Lable;
import javafx.scene.control.Alert;
import org.apache.batik.anim.dom.AnimatedLiveAttributeValue;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class LableDAOImpl implements LableDAO {

    @Override
    public List<Lable> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(Lable lable) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(Lable lable) throws ClassNotFoundException, SQLException {
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
    public void saveMessage(String text) throws SQLException, ClassNotFoundException {
        Connection con = Dbconnection.getObject().getConnection();
        String sql = "INSERT INTO lable (massege) VALUES (?)"; // replace `message_text` with actual column name
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, text);

        int result = pst.executeUpdate(); // returns number of rows affected

        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Message saved successfully.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message saved successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to save message.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Failed to save message.");
        }
    }

    @Override
    public String getmassege() throws SQLException, ClassNotFoundException {

        Connection con = Dbconnection.getObject().getConnection();
        String sql = "select * from lable";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if(rs.next()){
            return rs.getString("massege");
        }
        else{
            return "note ofer for yor you";

        }
    }

    @Override
    public void deletemethod(String massege) throws SQLException, ClassNotFoundException {
        Connection con = Dbconnection.getObject().getConnection();
        String sql = "DELETE FROM lable WHERE massege = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, massege);
        int result = pst.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Message deleted successfully.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Successfully");
            alert.show();
        }

    }
}
