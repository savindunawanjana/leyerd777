package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Coach;

import java.sql.SQLException;

public interface CoachDAO extends CrudDAO<Coach> {
    String findById(String coach1) throws SQLException, ClassNotFoundException;
}
