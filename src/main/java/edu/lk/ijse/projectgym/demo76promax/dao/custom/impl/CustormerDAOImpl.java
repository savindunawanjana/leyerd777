package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CustormerDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.SQLUtil;
import edu.lk.ijse.projectgym.demo76promax.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustormerDAOImpl implements CustormerDAO {

    @Override
    public List<Customer> getAll() throws ClassNotFoundException, SQLException {

        List<Customer> customerList = new ArrayList<>();
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT * FROM customer";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            customerList.add(new Customer(
                    result.getString("customer_id"),
                    result.getString("customer_name"),
                    result.getString("customer_address"),
                    result.getString("contact_number"),
                    result.getString("customer_birthday"),
                    result.getInt("customer_weight"),
                    result.getString("customer_email"),
                    result.getDouble("register_fees")
            ));
        }
        return customerList;

    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "DELETE FROM customer WHERE customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);

        int result = preparedStatement.executeUpdate();
        return result > 0;
    }

    @Override
    public Boolean update(Customer customer) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "UPDATE customer SET customer_name = ?, customer_address = ?, contact_number = ?, " +
                "customer_birthday = ?, customer_weight = ?, customer_email = ?, register_fees = ? " +
                "WHERE customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getAddress());
        preparedStatement.setString(3, customer.getCustomerNumber());
        preparedStatement.setString(4, customer.getCustomerBirthday());
        preparedStatement.setInt(5, customer.getCustomerWeight());
        preparedStatement.setString(6, customer.getCustomerEmail());
        preparedStatement.setDouble(7, customer.getCustomerRegisterFees());
        preparedStatement.setString(8, customer.getCustomerId());

        int result = preparedStatement.executeUpdate();
        return result > 0 ? true :false;//"Update successful" : "Update unsuccessful";
    }

    @Override
    public Boolean save(Customer customer) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, customer.getCustomerId());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setString(3, customer.getAddress());
        preparedStatement.setString(4, customer.getCustomerNumber());
        preparedStatement.setString(5, customer.getCustomerBirthday());
        preparedStatement.setInt(6, customer.getCustomerWeight());
        preparedStatement.setString(7, customer.getCustomerEmail());
        preparedStatement.setDouble(8, customer.getCustomerRegisterFees());

        int result = preparedStatement.executeUpdate();
        return result > 0 ? true : false;//"Saved successfully" : "Not saved";
    }

    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
       return null;
    }

    @Override
    public String findNameById(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = SQLUtil.execute(
                "SELECT customer_name FROM customer WHERE customer_id = ?",
                id
        );

        if (rst.next()) {

            return rst.getString(1);
        }
        return null;
    }

    @Override
    public List<String> getAllIds()throws ClassNotFoundException, SQLException {
        ResultSet rst = SQLUtil.execute(
                "select  customer_id from customer"
        );
        ArrayList<String> list = new ArrayList<>();
        while (rst.next()) {
            String id = rst.getString(1);
            list.add(id);

        }
        return list;
    }

    @Override
    public String findEmailById(String customerId) throws ClassNotFoundException, SQLException{
        ResultSet rst = SQLUtil.execute(
                "SELECT customer_email FROM customer WHERE customer_id = ?",
                customerId
        );
        if (rst.next()) {
            return rst.getString(1);
        }
        return "";
    }

    @Override
    public boolean isUserIdExists(String id) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT customer_id FROM customer WHERE customer_id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, id);

        ResultSet resultSet = pst.executeQuery();
        return resultSet.next();
    }


    /* this method throught can get next
      Id from the Custormer*/
    @Override
    public ResultSet getNextIdUnicForthisclass() throws ClassNotFoundException, SQLException {

        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT customer_id FROM customer ORDER BY customer_id DESC LIMIT 1";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet resultSet = pst.executeQuery();

        return resultSet;

    }

    @Override
    public Boolean findcustormerByponeNumber(String number) throws ClassNotFoundException, SQLException {


        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT * FROM customer WHERE contact_number = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, number);
        ResultSet resultSet = pst.executeQuery();

        return resultSet.next();
    }
}
