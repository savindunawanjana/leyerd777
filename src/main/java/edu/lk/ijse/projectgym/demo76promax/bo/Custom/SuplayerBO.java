package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.SuplayerDto;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuplayerBO extends SuperBO {
    String saveSuplayer(SuplayerDto dto) throws SQLException, ClassNotFoundException;
    ArrayList<SuplayerDto> getAll() throws SQLException, ClassNotFoundException;
    String  deleteSuplayer(String id) throws SQLException, ClassNotFoundException;
    String  updateSuplayer(SuplayerDto dto) throws SQLException, ClassNotFoundException;



}
