package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.DeleteClenerDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.ClenerdeleteBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.DeleteworkerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.WorkerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.dao.util.Publicforcoachandclener;
import edu.lk.ijse.projectgym.demo76promax.entity.DeleteWorker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClenerdeleteBOimpl implements ClenerdeleteBO {
    private WorkerDAO worker = DAOFactory.getInstance().getDao(DAOTipes.WORKER);
    private DeleteworkerDAO deleteworkerDAO = DAOFactory.getInstance().getDao(DAOTipes.DELETEWORKER);

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {

        Boolean rsp = worker.delete(id);
        Publicforcoachandclener.shouldBeRunThisMethod();
        return rsp==true ? true : false;

    }

    @Override
    public boolean saveDeleteCleaner(DeleteClenerDto dto) throws SQLException, ClassNotFoundException {

        DeleteWorker deleteWorker = new DeleteWorker(

                dto.getWorkerId(),
                dto.getWorkname(),
                dto.getDate(),
                dto.getUserRoller(),
                dto.getResonTodelete()
        );


        Boolean rsp = deleteworkerDAO.saveDeleteCleaner(deleteWorker);


        return rsp;
    }

    @Override
    public String findNameByIds(String id) throws SQLException, ClassNotFoundException {
         String id1 = worker.findNameById(id);
         return id1;
    }


}
