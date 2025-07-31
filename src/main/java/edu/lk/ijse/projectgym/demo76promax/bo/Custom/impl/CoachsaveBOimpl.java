package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.CoachsaveBO;
import edu.lk.ijse.projectgym.demo76promax.bo.util.EntityDTOConverter;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CoachDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.impl.CoachDAOImpl;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.Coach;

import java.sql.SQLException;
public class CoachsaveBOimpl implements CoachsaveBO {

    private CoachDAO coachDAO = DAOFactory.getInstance().getDao(DAOTipes.COACH) ;
private EntityDTOConverter entityDTOConverter = new EntityDTOConverter();
    @Override
    public String saveCoach(EmployeDto dto) throws SQLException, ClassNotFoundException {

       Coach coachentyty  =entityDTOConverter.getCoachEntity(dto);
        Boolean rsp = coachDAO.save(coachentyty);
        return rsp == true ? "saved succsess fully " : "saved Unsuccsess fully ";

    }
}
