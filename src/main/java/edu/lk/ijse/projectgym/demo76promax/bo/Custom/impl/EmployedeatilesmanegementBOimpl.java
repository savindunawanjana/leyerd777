package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeeDataDto;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.EmployedeatilesmanegementBO;
import edu.lk.ijse.projectgym.demo76promax.bo.util.EntityDTOConverter;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.EmplaoyTableDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeeTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployedeatilesmanegementBOimpl implements EmployedeatilesmanegementBO {
    private EntityDTOConverter entityDTOConverter = new EntityDTOConverter();
    private EmplaoyTableDAO emplaoyTableDAO= DAOFactory.getInstance().getDao(DAOTipes.EMPLOYEETABLE);

    @Override
    public List<EmployeeDataDto> getallMethod() throws SQLException, ClassNotFoundException {

        List<EmployeeDataDto>employeeDataDtoList = new ArrayList<>();
        List<EmployeeTable>employeedatlist=emplaoyTableDAO.getAll();

             for(EmployeeTable employeeTable : employeedatlist) {
                 EmployeeDataDto employeeDataDto=entityDTOConverter.getDtoemp(employeeTable);

                 employeeDataDtoList.add(employeeDataDto);

             }

          return employeeDataDtoList;

    }

    @Override
    public int setlableCoachCount() throws SQLException, ClassNotFoundException {

        int rsp1 = emplaoyTableDAO.setlableCoachCount();
        return rsp1;

    }

    @Override
    public int setlableCleanerCount() throws SQLException, ClassNotFoundException {

        int rsp2 =emplaoyTableDAO.setlableCleanerCount();
        return rsp2;

    }


}
