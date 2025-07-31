package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;

public interface CoachsaveBO  extends SuperBO {

    String saveCoach(EmployeDto dto) throws SQLException, ClassNotFoundException;


}
