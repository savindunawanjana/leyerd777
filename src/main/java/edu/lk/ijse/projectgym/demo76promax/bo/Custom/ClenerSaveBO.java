package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;

public interface ClenerSaveBO extends SuperBO {


    String saveWorker(EmployeDto dto) throws SQLException, ClassNotFoundException;

}
