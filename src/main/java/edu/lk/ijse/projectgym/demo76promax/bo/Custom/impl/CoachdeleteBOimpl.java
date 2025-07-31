package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.bo.Custom.CoachdeleteBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CoachDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;

import java.sql.SQLException;

public class CoachdeleteBOimpl implements CoachdeleteBO {

    private CoachDAO coachDAO = DAOFactory.getInstance().getDao(DAOTipes.COACH);

    @Override
    public String deleteCoach(String coachId) throws SQLException, ClassNotFoundException {
        boolean rsp = coachDAO.delete(coachId);
        return rsp == true ? "deleted succsessfully" : "Unsuccsessfully deleted";
    }
}
