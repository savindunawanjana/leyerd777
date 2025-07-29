package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.SystemUser;
import edu.lk.ijse.projectgym.demo76promax.bo.Exseption.Inusedexception;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;
import java.util.List;

public interface UsermanegeBO extends SuperBO {

    String getNextId() throws ClassNotFoundException, SQLException;
    Boolean delete(String id) throws ClassNotFoundException, SQLException;
    Boolean update(SystemUser systemUser) throws ClassNotFoundException, SQLException;
    Boolean save(SystemUser systemUser) throws ClassNotFoundException, SQLException, Inusedexception;
    String findNameById(String Id) throws ClassNotFoundException, SQLException;
    List<SystemUser> getuserinformation() throws SQLException, ClassNotFoundException;
    String getuserRollmethod(String user_password) throws SQLException, ClassNotFoundException;
    String getuserId(String user_password) throws SQLException, ClassNotFoundException;
    boolean isUserIdExists(String id) throws SQLException, ClassNotFoundException;
    public Boolean findcustormerByponeNumber(String number) throws ClassNotFoundException, SQLException,Inusedexception;


}
