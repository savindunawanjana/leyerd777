package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeeTable;

import java.sql.SQLException;

public interface EmplaoyTableDAO extends CrudDAO<EmployeeTable> {


    int setlableCoachCount() throws SQLException, ClassNotFoundException;
    int setlableCleanerCount() throws SQLException, ClassNotFoundException;

}
