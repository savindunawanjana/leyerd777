package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.ClenerSaveBO;
import edu.lk.ijse.projectgym.demo76promax.bo.util.EntityDTOConverter;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.WorkerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.Worker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
  // employeedataModel employeedataModel
public class ClenerSaveBOimpl implements ClenerSaveBO {
    private WorkerDAO workerDAO= DAOFactory.getInstance().getDao(DAOTipes.WORKER);
    private EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public String saveWorker(EmployeDto dto) throws SQLException, ClassNotFoundException {


       Worker worker = converter.getworkerEntity(dto);
        Boolean rsp = workerDAO.save(worker);


       return   rsp== true ? "success saved " : " Unsuccess saved ";
    }



}
