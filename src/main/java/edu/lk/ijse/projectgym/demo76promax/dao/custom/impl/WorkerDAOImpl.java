package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.WorkerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.SQLUtil;
import edu.lk.ijse.projectgym.demo76promax.entity.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class WorkerDAOImpl implements WorkerDAO {

    @Override
    public List<Worker> getAll() throws ClassNotFoundException, SQLException {
        ObservableList<Worker> list = FXCollections.observableArrayList();
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT * FROM worker";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            list.add(new Worker(
                    rs.getString("worker_id"),
                    rs.getString("worker_name"),
                    rs.getString("worker_number"),
                    rs.getString("system_user_Roll"),
                    rs.getDate("add_date"),
                    rs.getString("email")
            ));
        }
        return list;
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(Worker worker) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(Worker worker) throws ClassNotFoundException, SQLException {
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
