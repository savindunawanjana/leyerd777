package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.tm.ExsaisTm;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;
import java.util.List;

public interface ExsasaisdeatilesBo extends SuperBO {

    List<ExsaisTm> getAll() throws ClassNotFoundException, SQLException;
    Boolean delete(String id) throws ClassNotFoundException, SQLException;
    Boolean update(ExsaisTm exsaisTm) throws ClassNotFoundException, SQLException;
    Boolean save(ExsaisTm exsaisTm) throws ClassNotFoundException, SQLException;







}
