package edu.lk.ijse.projectgym.demo76promax.dao.custom;

import edu.lk.ijse.projectgym.demo76promax.dao.CrudDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CustormerDAO extends CrudDAO<Customer> {

  List<String> getAllIds() throws ClassNotFoundException, SQLException;

  public String findEmailById(String customerId) throws ClassNotFoundException, SQLException;

  public boolean isUserIdExists(String id) throws ClassNotFoundException, SQLException;

  ResultSet getNextIdUnicForthisclass() throws ClassNotFoundException, SQLException;

  public Boolean findcustormerByponeNumber(String number) throws ClassNotFoundException, SQLException;


}