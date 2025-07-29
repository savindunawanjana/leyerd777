package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Oders;

import java.sql.SQLException;

public interface OdersDAO extends CrudDAO<Oders> {

    boolean placeOrder(Oders oders)throws ClassNotFoundException, SQLException;
}
