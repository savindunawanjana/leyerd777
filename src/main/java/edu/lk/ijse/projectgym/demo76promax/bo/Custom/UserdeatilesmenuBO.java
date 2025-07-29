package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.SystemUser;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;
import java.util.List;

public interface UserdeatilesmenuBO extends SuperBO {

    List<SystemUser> getuserinformation() throws SQLException, ClassNotFoundException;

}
