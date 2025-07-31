package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeeDataDto;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.EmplaoyTableDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.SQLUtil;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeeTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmplaoyTableDAOImpl implements EmplaoyTableDAO {

    @Override
    public List<EmployeeTable> getAll() throws ClassNotFoundException, SQLException {
       List<EmployeeTable> Lists = new ArrayList<>();
        Connection connection = Dbconnection.getObject().getConnection();
        EmployeeDataDto employeeDataDto;
        String sql = "SELECT ALL * FROM  employees_table";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()) {
            EmployeeTable  emptable= new EmployeeTable(

                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("number"),
                    resultSet.getString("role"),
                    resultSet.getString("email")
            );
            Lists.add(emptable);

        }
        return Lists;
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(EmployeeTable employeeTable) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(EmployeeTable employeeTable) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public int setlableCoachCount() throws SQLException, ClassNotFoundException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT COUNT(*) AS employee_count FROM coaches";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return resultSet.getInt("employee_count");
        }
        return 0;

    }

    @Override
    public int setlableCleanerCount() throws SQLException, ClassNotFoundException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT COUNT(*) AS employee_count FROM worker";
        // String sql = "SELECT COUNT(*) AS employee_count FROM coaches";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()) {
            return resultSet.getInt("employee_count");
        }
        return 0;
    }
}
