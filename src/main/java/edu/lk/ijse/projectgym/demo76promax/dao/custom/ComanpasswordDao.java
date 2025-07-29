package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.CommonPassword;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ComanpasswordDao extends CrudDAO<CommonPassword> {

    String setComanPassword(String password) throws SQLException, ClassNotFoundException;

    String getComanPassword(String textfild) throws SQLException, ClassNotFoundException;


    ObservableList<CommonPassword> getComanPasswordFromDatabases() throws SQLException, ClassNotFoundException;

}
