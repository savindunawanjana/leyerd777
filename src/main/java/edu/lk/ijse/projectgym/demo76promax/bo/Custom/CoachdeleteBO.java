package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;

public interface CoachdeleteBO  extends SuperBO {

    String deleteCoach(String coachId) throws SQLException, ClassNotFoundException;

}
