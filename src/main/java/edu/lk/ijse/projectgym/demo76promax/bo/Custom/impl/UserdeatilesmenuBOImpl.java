package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;


import edu.lk.ijse.projectgym.demo76promax.Dtos.SystemUser;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.UserdeatilesmenuBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.SystemuserDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserdeatilesmenuBOImpl  implements UserdeatilesmenuBO {

    private SystemuserDAO systemuserDAO = DAOFactory.getInstance().getDao(DAOTipes.SYSTEMUSER);
   private  List<SystemUser> allusers = new ArrayList<>();

    @Override
    public List<SystemUser> getuserinformation() throws SQLException, ClassNotFoundException {

        List<edu.lk.ijse.projectgym.demo76promax.entity.SystemUser> cachobjectList = systemuserDAO.getuserinformation();

        for (edu.lk.ijse.projectgym.demo76promax.entity.SystemUser systemUser : cachobjectList) {

            SystemUser sysUser = new SystemUser(

                    systemUser.getUserId(),
                    systemUser.getPassword(),
                    systemUser.getUserId(),
                    systemUser.getSystemUsername(),
                    systemUser.getContactNumber()
            );
            allusers.add(sysUser);

        }


        return allusers;

    }
}
