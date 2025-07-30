package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;

import java.sql.SQLException;

public interface CoachsaveBO {

    String saveCoach(EmployeDto dto) throws SQLException, ClassNotFoundException;


}
