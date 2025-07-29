package edu.lk.ijse.projectgym.demo76promax.bo.Custom;

import edu.lk.ijse.projectgym.demo76promax.Dtos.CustermerDto;
import edu.lk.ijse.projectgym.demo76promax.bo.Exseption.Inusedexception;
import edu.lk.ijse.projectgym.demo76promax.bo.Exseption.Notfoundexseption;
import edu.lk.ijse.projectgym.demo76promax.bo.SuperBO;

import java.sql.SQLException;
import java.util.List;

public interface CustormerManegeBO extends SuperBO {


    List<CustermerDto> getrAllcustormer()throws SQLException,ClassNotFoundException,Notfoundexseption;

    String getNextId()throws SQLException, ClassNotFoundException;

    String findNameById( String Id) throws SQLException, ClassNotFoundException;

    List<String> getAllIds()throws SQLException, ClassNotFoundException;

    String findEmailById(String customerId)throws SQLException, ClassNotFoundException;

    boolean isUserIdExists(String id)throws SQLException, ClassNotFoundException;

    String updateCustomer(CustermerDto customer)throws SQLException, ClassNotFoundException;

    String saveCustomer(CustermerDto customer)throws SQLException, ClassNotFoundException, Inusedexception;

    boolean deleteCustomerById(String customerId)throws SQLException, ClassNotFoundException;

}
