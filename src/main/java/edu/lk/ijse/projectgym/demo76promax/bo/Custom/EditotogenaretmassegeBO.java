package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;

public interface EditotogenaretmassegeBO extends SuperBO {

    void saveMessage(String text) throws SQLException, ClassNotFoundException;
    String getmassege() throws SQLException, ClassNotFoundException;
    void deletemethod(String massege) throws SQLException, ClassNotFoundException;

}
