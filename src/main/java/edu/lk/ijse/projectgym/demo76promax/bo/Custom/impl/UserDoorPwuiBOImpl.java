package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.comanPasswordobject;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.UserDoorPwuiBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.ComanpasswordDao;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.CommonPassword;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class UserDoorPwuiBOImpl implements UserDoorPwuiBO {
    private ComanpasswordDao comanpasswordDao = DAOFactory.getInstance().getDao(DAOTipes.COMMONPASSWORD);
    @Override
    public String setComanPassword(String password) throws SQLException, ClassNotFoundException {
        String cach = comanpasswordDao.setComanPassword(password);


        return cach;
    }

    @Override
    public String getComanPassword(String textfild) throws SQLException, ClassNotFoundException {
        String password = comanpasswordDao.getComanPassword(textfild);
        return password;

    }

    @Override
    public ObservableList<comanPasswordobject> getComanPasswordFromDatabases() throws SQLException, ClassNotFoundException {

        ObservableList<CommonPassword> lict = comanpasswordDao.getComanPasswordFromDatabases();
        ObservableList<comanPasswordobject> dtolist = FXCollections.observableArrayList();

        for (CommonPassword commonPasswordeka : lict) {

            comanPasswordobject password = new comanPasswordobject(
                    commonPasswordeka.getPassword()
            );
            dtolist.add(password);

//Savindu Nawanajana

        }


        return dtolist;
    }
}
