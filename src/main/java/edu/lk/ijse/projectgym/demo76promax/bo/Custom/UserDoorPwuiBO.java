package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.comanPasswordobject;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface UserDoorPwuiBO extends SuperBO {
    String setComanPassword(String password) throws SQLException, ClassNotFoundException;
    String getComanPassword(String textfild) throws SQLException, ClassNotFoundException;
    ObservableList<comanPasswordobject> getComanPasswordFromDatabases() throws SQLException, ClassNotFoundException;

}
