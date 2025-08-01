package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.tm.ExsaisTm;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.ManegeExsersaisDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.ManegeExercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManegeexsersaisDAOImpl implements ManegeExsersaisDAO {

    @Override
    public List<ManegeExercise> getAll() throws ClassNotFoundException, SQLException {
        List<ManegeExercise> list = new ArrayList();
        Connection connection1 = Dbconnection.getObject().getConnection();
        String sql = "SELECT * FROM manage_exercises";
        PreparedStatement preparedStatement = connection1.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ManegeExercise manegeExercise;

        while (resultSet.next()) {
            manegeExercise = new ManegeExercise(

                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("category"),
                    resultSet.getTimestamp("added_date"),
                    resultSet.getString("system_user_id")
            );

            list.add(manegeExercise);
        }

        return list;
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        Connection connection1 = Dbconnection.getObject().getConnection();
        String sql = "DELETE FROM manage_exercises WHERE id=?";
        PreparedStatement preparedStatement = connection1.prepareStatement(sql);
        preparedStatement.setString(1, id);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean update(ManegeExercise manegeExercise) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "UPDATE manage_exercises SET  name=?,category=? WHERE id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, manegeExercise.getExerciseName());
        preparedStatement.setString(2, manegeExercise.getCategory());

        preparedStatement.setInt(3, manegeExercise.getExerciseId());
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            return  true;
        } else {
            return  false ;
        }
    }

    @Override
    public Boolean save(ManegeExercise manegeExercise) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "INSERT INTO manage_exercises(id, name, category, system_user_id) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, manegeExercise.getExerciseId());
        preparedStatement.setString(2, manegeExercise.getExerciseName());
        preparedStatement.setString(3, manegeExercise.getCategory());
        preparedStatement.setString(4, manegeExercise.getSystemUserId());  // <-- use systemUserid here!

        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            return true;
        } else {
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
