package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeeDataDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.EmployeeManegeFirstpageBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CoachDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.WorkerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.impl.CoachDAOImpl;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.Coach;

import java.sql.SQLException;
import java.util.List;



public class EmployeeManegeFirstpageBOimpl implements EmployeeManegeFirstpageBO {

    private CoachDAO  coachDAO = DAOFactory.getInstance().getDao(DAOTipes.COACH);
    private WorkerDAO workerDao = DAOFactory.getInstance().getDao(DAOTipes.WORKER);


    @Override
    public List<EmployeDto> getcoachdata() throws SQLException, ClassNotFoundException {

        List<Coach>coachlist=coachDAO.getAll();


        return List.of();
    }

    @Override
    public List<EmployeDto> getworkerdata() throws SQLException, ClassNotFoundException {
        return List.of();
    }



//    @Override
//    public String deleteWorker(String workerId) throws SQLException, ClassNotFoundException {
//        return "";
//    }
//
//    @Override
//    public String deleteCoach(String coachId) throws SQLException, ClassNotFoundException {
//        return "";
//    }

    @Override
    public int setlableCoachCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int setlableCleanerCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public String findNameById(String id) throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public String findNameByIds(String id) throws SQLException, ClassNotFoundException {
        return "";
    }
}
