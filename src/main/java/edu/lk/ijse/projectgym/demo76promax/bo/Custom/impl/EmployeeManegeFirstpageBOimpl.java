package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeeDataDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.EmployeeManegeFirstpageBO;
import edu.lk.ijse.projectgym.demo76promax.bo.util.EntityDTOConverter;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CoachDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.WorkerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.impl.CoachDAOImpl;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.Coach;
import edu.lk.ijse.projectgym.demo76promax.entity.Worker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManegeFirstpageBOimpl implements EmployeeManegeFirstpageBO {
private EntityDTOConverter  entityDTOConverter= new EntityDTOConverter();
    private CoachDAO  coachDAO = DAOFactory.getInstance().getDao(DAOTipes.COACH);
    private WorkerDAO workerDao = DAOFactory.getInstance().getDao(DAOTipes.WORKER);

    @Override
    public List<EmployeDto> getcoachdata() throws SQLException, ClassNotFoundException {

        List<Coach>coachlist=coachDAO.getAll();
       List<EmployeDto>lists = new ArrayList<>();

        for (Coach coach : coachlist) {

           EmployeDto dto = entityDTOConverter.getCoachDto(coach);
            lists.add(dto);
        }

        return  lists ;
    }

    @Override
    public List<EmployeDto> getworkerdata() throws SQLException, ClassNotFoundException {

        List<Worker>workerlist=workerDao.getAll();
        List<EmployeDto>lists = new ArrayList<>();

        for (Worker worker : workerlist) {

            EmployeDto dto = entityDTOConverter.getWorkerDtos(worker);
            lists.add(dto);
        }

        return  lists ;
    }

    @Override
    public int setlableCoachCount() throws SQLException, ClassNotFoundException {
        int cachnumber = coachDAO.setlableCoachCount();
        return cachnumber;
    }

    @Override
    public int setlableCleanerCount() throws SQLException, ClassNotFoundException {
        int cachnumber = workerDao.setlableCleanerCount();
        return cachnumber;
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
