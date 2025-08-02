package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.tm.ExsaisTm;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SendshedultoCustormerBO extends SuperBO {

    ArrayList<ExsaisTm> getAllmethod() throws SQLException, ClassNotFoundException;



}
