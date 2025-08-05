package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.bo.Custom.EditotogenaretmassegeBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.LableDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;

import java.sql.SQLException;

public class EditotogenaretmassegeBOimpl implements EditotogenaretmassegeBO {
private LableDAO lableDAO = DAOFactory.getInstance().getDao(DAOTipes.LABLE);

    @Override
    public void saveMessage(String text) throws SQLException, ClassNotFoundException {

       lableDAO.saveMessage(text);

    }

    @Override
    public String getmassege() throws SQLException, ClassNotFoundException {

      return   lableDAO.getmassege();

    }

    @Override
    public void deletemethod(String massege) throws SQLException, ClassNotFoundException {

        lableDAO.deletemethod(massege);



    }
}
