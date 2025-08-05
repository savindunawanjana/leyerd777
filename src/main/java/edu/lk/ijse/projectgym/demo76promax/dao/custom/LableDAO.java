package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Lable;

import java.sql.SQLException;

public interface LableDAO extends CrudDAO<Lable> {

    void saveMessage(String text) throws SQLException, ClassNotFoundException;
    String getmassege() throws SQLException, ClassNotFoundException;
    void deletemethod(String massege) throws SQLException, ClassNotFoundException;

}
