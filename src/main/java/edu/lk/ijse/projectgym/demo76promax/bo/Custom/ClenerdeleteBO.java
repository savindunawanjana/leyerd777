package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.DeleteClenerDto;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.WorkerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.DeleteWorker;

import java.sql.SQLException;

public interface ClenerdeleteBO  extends SuperBO {

//    private WorkerDAO worker = DAOFactory.getInstance().getDao(DAOTipes.WORKER);
   Boolean delete(String id) throws ClassNotFoundException, SQLException;
   boolean saveDeleteCleaner(DeleteClenerDto dto) throws SQLException, ClassNotFoundException;
   String findNameByIds(String id) throws SQLException, ClassNotFoundException;

}
