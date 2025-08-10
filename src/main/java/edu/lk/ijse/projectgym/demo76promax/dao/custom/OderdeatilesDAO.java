package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.OrderDetailsDTO;
import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.OderDeatiles;

import java.sql.SQLException;
import java.util.List;

public interface OderdeatilesDAO extends CrudDAO<OderDeatiles> {

    Boolean saveOderdeatilesList(List<OderDeatiles> cartList) throws ClassNotFoundException, SQLException;
    boolean saveOrderDetails(OderDeatiles orderentyty) throws SQLException, ClassNotFoundException;
}
