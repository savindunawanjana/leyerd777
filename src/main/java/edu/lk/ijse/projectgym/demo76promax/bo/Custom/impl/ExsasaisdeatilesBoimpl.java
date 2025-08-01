package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.tm.ExsaisTm;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.ExsasaisdeatilesBo;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.ManegeExsersaisDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.ManegeExercise;

import java.sql.SQLException;
import java.util.List;

public class ExsasaisdeatilesBoimpl implements ExsasaisdeatilesBo {
    private ManegeExsersaisDAO manegeExsersaisDAO= DAOFactory.getInstance().getDao(DAOTipes.MANEGEEXERCISE);

    @Override
    public List<ExsaisTm> getAll() throws ClassNotFoundException, SQLException {
        List<ManegeExercise> list = manegeExsersaisDAO.getAll();
        List<ExsaisTm> exsaisTms = new java.util.ArrayList<>();
        for (ManegeExercise manegeExercise : list) {

            ExsaisTm exsaisTm = new ExsaisTm(

                    manegeExercise.getExerciseId(),
                    manegeExercise.getExerciseName(),
                    manegeExercise.getCategory(),
                    manegeExercise.getAddDate(),
                    manegeExercise.getSystemUserId()

            );
            exsaisTms.add(exsaisTm);
        }

        return exsaisTms;

    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
                     Boolean rsp =manegeExsersaisDAO.delete(id);
                     return rsp==true ? true : false;
    }

    @Override
    public Boolean update(ExsaisTm exsaisTm) throws ClassNotFoundException, SQLException {

        ManegeExercise manegeExercise = new ManegeExercise(

                exsaisTm.getId(),
                exsaisTm.getExsaisName(),
                exsaisTm.getExsaisCategory(),
                exsaisTm.getDate(),
                exsaisTm.getSystemUserRoll()
        );

         Boolean rsp = manegeExsersaisDAO.update(manegeExercise);

        return rsp;
    }

    @Override
    public Boolean save(ExsaisTm exsaisTm) throws ClassNotFoundException, SQLException {

        ManegeExercise manegeExercise = new ManegeExercise(

                exsaisTm.getId(),
                exsaisTm.getExsaisName(),
                exsaisTm.getExsaisCategory(),
                exsaisTm.getDate(),
                exsaisTm.getSystemUserRoll()
        );

       Boolean rsp = manegeExsersaisDAO.save(manegeExercise);
        return rsp;


    }
}
