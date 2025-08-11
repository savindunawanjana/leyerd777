package edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dtos.SuplayerDto;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.SuplayerBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.SuplayersDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import edu.lk.ijse.projectgym.demo76promax.entity.Suppliers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuplayerBOimpl implements SuplayerBO {

private SuplayersDAO suplayersDAO= DAOFactory.getInstance().getDao(DAOTipes.SUPPLIERS);

    @Override
    public String saveSuplayer(SuplayerDto dto) throws SQLException, ClassNotFoundException {


        Suppliers suppliers = new Suppliers(
                dto.getSupplier_id(),
                dto.getSupplier_name(),
                dto.getPone_number(),
                dto.getEmail(),
                dto.getAddress()
        );



        Boolean cach =suplayersDAO.save(suppliers);

        String rsp = cach == true ? "Save Succcses full":"Save UnSucccses full";

        return rsp;
    }

    @Override
    public ArrayList<SuplayerDto> getAll() throws SQLException, ClassNotFoundException {

        List<Suppliers>entytyList =suplayersDAO.getAll();
ArrayList<SuplayerDto> dtoList = new ArrayList<>();
        for(Suppliers suppliers : entytyList){

           SuplayerDto dto = new SuplayerDto(

                   suppliers.getSupplierId(),
                   suppliers.getName(),
                   suppliers.getContactNumber(),
                   suppliers.getEmail(),
                   suppliers.getAddress()
           );

            dtoList.add(dto);
        }


        return dtoList;
    }

    @Override
    public String deleteSuplayer(String id) throws SQLException, ClassNotFoundException {
        Boolean cach =suplayersDAO.delete(id);

        String rsp = cach==true ? "Delete Succcses full":"Delete UnSucccses full";
        return rsp;
    }

    @Override
    public String updateSuplayer(SuplayerDto dto) throws SQLException, ClassNotFoundException {

        Suppliers suppliers = new Suppliers(
                dto.getSupplier_id(),
                dto.getSupplier_name(),
                dto.getPone_number(),
                dto.getEmail(),
                dto.getAddress()
        );

         Boolean cach = suplayersDAO.update(suppliers);
         String rsp = cach==true ? "Update Succcses full":"Update UnSucccses full";
         return rsp;

    }
}
