package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeeDataDto;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface EmployedeatilesmanegementBO extends SuperBO {

    List<EmployeeDataDto> getallMethod() throws SQLException, ClassNotFoundException;
    int setlableCoachCount() throws SQLException, ClassNotFoundException;
    int setlableCleanerCount() throws SQLException, ClassNotFoundException;


}
