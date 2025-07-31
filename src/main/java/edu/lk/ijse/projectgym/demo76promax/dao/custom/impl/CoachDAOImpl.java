package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CoachDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.SQLUtil;
import edu.lk.ijse.projectgym.demo76promax.entity.Coach;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoachDAOImpl implements CoachDAO {

    @Override
    public String findById(String coach1) throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public List<Coach> getAll() throws ClassNotFoundException, SQLException {
       List<Coach> list = new ArrayList<>();
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT * FROM coaches";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            list.add(new Coach(
                    rs.getString("coach_id"),
                    rs.getString("coach_name"),
                    rs.getString("coach_number"),
                    rs.getString("system_user_Roll"),
                    rs.getDate("add_date"),
                    rs.getString("email")
            ));
        }
        return list;
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM coaches WHERE coach_id=?";
        try {Connection connection = Dbconnection.getObject().getConnection();
             PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            int result = stm.executeUpdate();
            return result > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(Coach coach) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(Coach coach) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = Dbconnection.getObject().getConnection();
            String sql = "INSERT INTO coaches(coach_id, coach_name, coach_number, system_user_Roll,add_date,email) VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, coach.getCoachId());
            stmt.setString(2, coach.getName());
            stmt.setString(3, coach.getContactNumber());
            stmt.setString(4, coach.getSystemUserRole());
            stmt.setDate(5, coach.getAddDate());
            stmt.setString(6, coach.getEmail());

            int result = stmt.executeUpdate();
            return result > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
}
