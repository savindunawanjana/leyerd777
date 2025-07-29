package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.SystemUser;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.UsermanegeBO;
import edu.lk.ijse.projectgym.demo76promax.bo.Exseption.Inusedexception;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.SystemuserDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsermanegeBOImpl implements UsermanegeBO {
    private SystemuserDAO systemuserDAO = DAOFactory.getInstance().getDao(DAOTipes.SYSTEMUSER);

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        Boolean cach = systemuserDAO.delete(id);
        return cach;
    }

    @Override
    public Boolean update(SystemUser systemUser) throws ClassNotFoundException, SQLException {

        edu.lk.ijse.projectgym.demo76promax.entity.SystemUser systemUser1 = new edu.lk.ijse.projectgym.demo76promax.entity.SystemUser(

                systemUser.getUser_Id(),
                systemUser.getUser_password(),
                systemUser.getUser_Roll(),
                systemUser.getUser_Name(),
                systemUser.getPon_number()

        );

        Boolean cach = systemuserDAO.update(systemUser1);
        return cach;
    }

    @Override
    public Boolean save(SystemUser systemUser) throws ClassNotFoundException, SQLException, Inusedexception {

        edu.lk.ijse.projectgym.demo76promax.entity.SystemUser systemUser1 = new edu.lk.ijse.projectgym.demo76promax.entity.SystemUser(
                systemUser.getUser_Id(),
                systemUser.getUser_password(),
                systemUser.getUser_Roll(),
                systemUser.getUser_Name(),
                systemUser.getPon_number()

        );

                boolean cach1 = systemuserDAO.getcustormerbypassword(systemUser.getUser_password());
                             boolean cach2  = systemuserDAO.finduserByponeNumber(systemUser.getPon_number());

                if(cach1){

                               throw new Inusedexception("This password is already exists");

                }

                if(cach2){

                    throw new Inusedexception("This pone number is already exists");

                }


        Boolean cach = systemuserDAO.save(systemUser1);
        return cach;

    }

    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public List<SystemUser> getuserinformation() throws SQLException, ClassNotFoundException {

        List<edu.lk.ijse.projectgym.demo76promax.entity.SystemUser> information = systemuserDAO.getuserinformation();
         List<SystemUser>dtolist = new ArrayList<>();
        for (edu.lk.ijse.projectgym.demo76promax.entity.SystemUser systemUser : information) {

         SystemUser sysUser = new SystemUser(
                 systemUser.getUserId(),
                 systemUser.getPassword(),
                 systemUser.getSystemrole(),
                 systemUser.getSystemUsername(),
                 systemUser.getContactNumber()
         );

            dtolist.add(sysUser);

        }

        return dtolist;

    }

    @Override
    public String getuserRollmethod(String user_password) throws SQLException, ClassNotFoundException {
        String roal = systemuserDAO.getuserRollmethod(user_password);
        return  roal;
    }

    @Override
    public String getuserId(String user_password) throws SQLException, ClassNotFoundException {
        String id = systemuserDAO.getuserId(user_password);
        return id;
    }

    @Override
    public boolean isUserIdExists(String id) throws SQLException, ClassNotFoundException {
        Boolean cach =systemuserDAO.isUserIdExists(id);
        return cach;
    }

    @Override
    public Boolean findcustormerByponeNumber(String number) throws ClassNotFoundException, SQLException, Inusedexception {
        return systemuserDAO.finduserByponeNumber(number);

    }

    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        ResultSet resultSet = systemuserDAO.getNextIdeka();

        char prefix = 'U';
        if (resultSet.next()) {
            String lastId = resultSet.getString(1);
            String numericPart = lastId.substring(1);
            int nextIdNum = Integer.parseInt(numericPart) + 1;
            return String.format(prefix + "%03d", nextIdNum);
        }
        return prefix + "001";

    }
}
