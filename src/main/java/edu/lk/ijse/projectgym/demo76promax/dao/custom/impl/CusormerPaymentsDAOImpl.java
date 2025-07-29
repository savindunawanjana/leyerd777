package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CusormerPaymentsDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.CustomerPayment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CusormerPaymentsDAOImpl implements CusormerPaymentsDAO {

    @Override
    public List<CustomerPayment> getAll() throws ClassNotFoundException, SQLException {

        List<CustomerPayment> members = new ArrayList<>();

        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT * FROM customer_payment";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            members.add(new CustomerPayment(
                    resultSet.getInt("payment_id"),
                    resultSet.getString("customer_id"),
                    resultSet.getDate("expire_date"),
                    resultSet.getInt("valid_number_of_month"),
                    resultSet.getString("system_user_roll"),
                    resultSet.getDate("payment_date"),
                    resultSet.getBigDecimal("payment_amount")));

        }

        return members;

    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(CustomerPayment customerPayment) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(CustomerPayment customerPayment) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = " INSERT INTO customer_payment(customer_id,expire_date,valid_number_of_month,system_user_roll,payment_date,payment_amount)VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, customerPayment.getCustomerId());
        preparedStatement.setString(2, String.valueOf(customerPayment.getExpayerDate()));
        preparedStatement.setInt(3, customerPayment.getValidNomberOfMonths());
        preparedStatement.setString(4, customerPayment.getSystemUserRoll());
        preparedStatement.setString(5, String.valueOf(customerPayment.getPaymentDate()));
        preparedStatement.setBigDecimal(6, customerPayment.getPaymentAmount());

        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
        return rowsAffected > 0;
    }



    @Override
    public String getNextId() throws ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public String findNameById(String Id) throws ClassNotFoundException, SQLException {
        return "";
    }



    @Override
    public String deleteLowerPaymentIdsPerCustomer() throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = """
                    DELETE FROM customer_payment
                    WHERE payment_id NOT IN (
                        SELECT * FROM (
                            SELECT MAX(payment_id)
                            FROM customer_payment
                            GROUP BY customer_id
                        ) AS latest
                    )
                """;

        Statement statement = connection.createStatement();
        int deletedRows = statement.executeUpdate(sql);
        return deletedRows > 0 ? "Deleted old payments successfully" : "No old payments to delete.";


    }
}
