package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CoachDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Coach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CoachDAOImpl implements CoachDAO {

    @Override
    public String findById(String coach1) throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public List<Coach> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM coaches WHERE coach_id=?";
        try (Connection connection = Dbconnection.getObject().getConnection();
             PreparedStatement stm = connection.prepareStatement(sql)) {
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
            stmt.setString(5, String.valueOf(coach.getAddDate()));
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
}
