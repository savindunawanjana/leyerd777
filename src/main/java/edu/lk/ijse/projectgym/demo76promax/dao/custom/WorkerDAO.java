package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Worker;

import java.sql.SQLException;

public interface WorkerDAO extends CrudDAO<Worker> {
    int setlableCleanerCount() throws SQLException, ClassNotFoundException;
}
