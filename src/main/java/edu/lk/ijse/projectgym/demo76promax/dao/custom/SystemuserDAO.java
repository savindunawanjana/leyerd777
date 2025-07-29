package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.bo.Exseption.Inusedexception;
import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.SystemUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface SystemuserDAO extends CrudDAO<SystemUser> {

    List<SystemUser> getuserinformation() throws SQLException, ClassNotFoundException;

    // ResultSet getOwnerInformation() throws SQLException, ClassNotFoundException
    String getuserRollmethod(String user_password) throws SQLException, ClassNotFoundException;

    String getuserId(String user_password) throws SQLException, ClassNotFoundException;

    boolean isUserIdExists(String id) throws SQLException, ClassNotFoundException;

    ResultSet getNextIdeka() throws ClassNotFoundException, SQLException;

    Boolean getcustormerbypassword(String user_password) throws SQLException, ClassNotFoundException, Inusedexception;

    Boolean finduserByponeNumber(String number) throws ClassNotFoundException, SQLException;
}
