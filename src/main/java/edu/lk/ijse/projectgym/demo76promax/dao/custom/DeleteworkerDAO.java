package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.DeleteClenerDto;
import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.DeleteWorker;

import java.sql.SQLException;

public interface DeleteworkerDAO extends CrudDAO<DeleteWorker> {
    //this cllas can only save  of adelete clener
    boolean saveDeleteCleaner(DeleteWorker entyty) throws SQLException, ClassNotFoundException;

}
