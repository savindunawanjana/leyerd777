package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.DeleteClenerDto;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.DeleteworkerDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.DeleteWorker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeleteworkerDAOImpl implements DeleteworkerDAO {
//this cllas can only save  of adelete clener

    @Override
    public List<DeleteWorker> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(DeleteWorker deleteWorker) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(DeleteWorker deleteWorker) throws ClassNotFoundException, SQLException {

        return null;
    }

    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean saveDeleteCleaner(DeleteWorker entyty) throws SQLException, ClassNotFoundException {
        Connection connection = Dbconnection.getObject().getConnection();

        String sql = "INSERT INTO delete_worker(worker_id,worker_name,delete_date,system_user_Roll,reason_to_delete) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, entyty.getWorkerId());
        stmt.setString(2, entyty.getWorkername());
        stmt.setString(3, entyty.getDeleteDate());
        stmt.setString(4, entyty.getSystemUserId());
        stmt.setString(5, String.valueOf(entyty.getResonTodelete()));
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;

    }
}
