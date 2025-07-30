package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeeDataDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeManegeFirstpageBO {

    // methana worker kiyanne cleners lata save karanne cleners lage deatiles

    List<EmployeDto> getcoachdata() throws SQLException, ClassNotFoundException;
    List<EmployeDto> getworkerdata() throws SQLException, ClassNotFoundException;
    int setlableCoachCount() throws SQLException, ClassNotFoundException;
    int setlableCleanerCount() throws SQLException, ClassNotFoundException;
    String findNameById(String id) throws SQLException, ClassNotFoundException;
    String findNameByIds(String id) throws SQLException, ClassNotFoundException;


}
