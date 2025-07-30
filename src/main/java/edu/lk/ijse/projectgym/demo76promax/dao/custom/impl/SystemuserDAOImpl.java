package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.bo.Exseption.Inusedexception;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.SystemuserDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.SQLUtil;
import edu.lk.ijse.projectgym.demo76promax.entity.SystemUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SystemuserDAOImpl implements SystemuserDAO {

    @Override
    public List<SystemUser> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM system_user WHERE user_id = ?";
        return SQLUtil.execute(sql, id);

    }

    @Override
    public Boolean update(SystemUser systemUser) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE system_user SET user_password = ?, user_role = ?, user_name = ?, phone_number = ? WHERE user_id = ?";
        return SQLUtil.execute(sql,
                systemUser.getPassword(),
                systemUser.getSystemrole(),
                systemUser.getSystemUsername(),
                systemUser.getContactNumber(),
                systemUser.getUserId());
    }

    @Override
    public Boolean save(SystemUser systemUser) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "INSERT INTO system_user VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, systemUser.getUserId());
        preparedStatement.setString(2, systemUser.getPassword());
        preparedStatement.setString(3, systemUser.getSystemrole());
        preparedStatement.setString(4, systemUser.getSystemUsername());
        preparedStatement.setString(5, systemUser.getContactNumber());

        int result = preparedStatement.executeUpdate();
        return result > 0 ? true : false;//"save successfully" : "not saved"
    }

    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT user_id FROM system_user ORDER BY user_id DESC LIMIT 1";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet resultSet = pst.executeQuery();

        char prefix = 'U';
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String numericPart = lastId.substring(1);
            int nextIdNum = Integer.parseInt(numericPart) + 1;
            return String.format(prefix + "%03d", nextIdNum);
        }
        return prefix + "001";
    }

    @Override
    public ResultSet getNextIdeka() throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT user_id FROM system_user ORDER BY user_id DESC LIMIT 1";
        PreparedStatement pst = connection.prepareStatement(sql);
        return pst.executeQuery();

    }

    @Override
    public Boolean getcustormerbypassword(String user_password) throws SQLException, ClassNotFoundException, Inusedexception {

        Connection connection = Dbconnection.getObject().getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM system_user WHERE user_password = ?");
        preparedStatement.setString(1, user_password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    @Override
    public Boolean finduserByponeNumber(String number) throws ClassNotFoundException, SQLException{

        Connection connection = Dbconnection.getObject().getConnection();
        String sql="SELECT * FROM system_user WHERE  phone_number= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, number);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }


    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public List<SystemUser> getuserinformation() throws SQLException, ClassNotFoundException {

        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT * FROM system_user";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();

        List<SystemUser> userInformation = new ArrayList<>();

        while (rst.next()) {
            SystemUser dto = new SystemUser(
                    rst.getString("user_id"),
                    rst.getString("user_password"),
                    rst.getString("user_role"),
                    rst.getString("user_name"),
                    rst.getString("phone_number")
            );
            userInformation.add(dto);
        }

        return userInformation;
    }

    @Override
    public String getuserRollmethod(String user_password) throws SQLException, ClassNotFoundException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT user_role FROM system_user WHERE user_password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user_password);
        ResultSet rs = preparedStatement.executeQuery();

        String role = null;
        if (rs.next()) {
            role = rs.getString("user_role");
        }
        return role;
    }

    @Override
    public String getuserId(String user_password) throws SQLException, ClassNotFoundException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT user_id FROM system_user WHERE user_password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user_password);
        ResultSet rs = preparedStatement.executeQuery();

        String id = null;
        if (rs.next()) {
            id = rs.getString("user_id");
        }
        return id;
    }

    @Override
    public boolean isUserIdExists(String id) throws SQLException, ClassNotFoundException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT user_id FROM system_user WHERE user_id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, id);
        ResultSet resultSet = pst.executeQuery();
        return resultSet.next();
        /* if have a resulset this throught return boolian value*/
    }




}
