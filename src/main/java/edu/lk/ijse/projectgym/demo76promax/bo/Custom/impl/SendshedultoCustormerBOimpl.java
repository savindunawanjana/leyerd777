package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.tm.ExsaisTm;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.SendshedultoCustormerBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.ManegeExsersaisDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.SendshedultocustormerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.ManegeExercise;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SendshedultoCustormerBOimpl implements SendshedultoCustormerBO {

    private ManegeExsersaisDAO manegeExsersaisDAO= DAOFactory.getInstance().getDao(DAOTipes.MANEGEEXERCISE);
    @Override
    public ArrayList<ExsaisTm> getAllmethod() throws SQLException, ClassNotFoundException {

       List<ManegeExercise> manegeExercise =manegeExsersaisDAO.getAll();
       ArrayList<ExsaisTm> exsaisTms = new ArrayList<>();
       for (ManegeExercise manegeExercise1 : manegeExercise) {

           ExsaisTm exsaisTm = new ExsaisTm(
                   manegeExercise1.getExerciseId(),
                   manegeExercise1.getExerciseName(),
                   manegeExercise1.getCategory(),
                   manegeExercise1.getAddDate(),
                   manegeExercise1.getSystemUserId()
           );

           exsaisTms.add(exsaisTm);
       }

        return exsaisTms ;
    }
}
