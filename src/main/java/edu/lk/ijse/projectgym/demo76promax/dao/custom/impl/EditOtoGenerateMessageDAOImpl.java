package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.EditOtoGenerateMessageDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.EditOtoGenaretMassege;

import java.sql.SQLException;
import java.util.List;

public class EditOtoGenerateMessageDAOImpl implements EditOtoGenerateMessageDAO {

    @Override
    public List<EditOtoGenaretMassege> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(EditOtoGenaretMassege editOtoGenaretMassege) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(EditOtoGenaretMassege editOtoGenaretMassege) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return "";
    }
}
