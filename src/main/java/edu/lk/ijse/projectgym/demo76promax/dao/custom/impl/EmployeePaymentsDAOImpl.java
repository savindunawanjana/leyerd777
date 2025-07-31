package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.employePaymentDto;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.EmployeePaymentsDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeePayments;

import java.sql.*;
import java.util.List;

public class EmployeePaymentsDAOImpl implements EmployeePaymentsDAO {

    @Override
    public List<EmployeePayments> getAll() throws ClassNotFoundException, SQLException {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean update(EmployeePayments employeePayments) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Boolean save(EmployeePayments employeePayments) throws ClassNotFoundException, SQLException {
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

    @Override
    public boolean saveMethod1(EmployeePayments entyty) throws SQLException, ClassNotFoundException {
        Connection connection = Dbconnection.getObject().getConnection();

        String sql = """
                    INSERT INTO employee_payments
                    (system_user_roll, employee_role, employee_id, payment_date, salary)
                    VALUES (?, ?, ?, ?, ?)
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entyty.getSystemUserRoll());
            preparedStatement.setString(2, entyty.getEmployeeRole());
            preparedStatement.setString(3, entyty.getEmployeeId());
            preparedStatement.setString(4, entyty.getPaymentDate());
            preparedStatement.setDouble(5, entyty.getSalary());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;


    }

    @Override
    public String searchEmployeePaymentsById(String employeeId) throws SQLException, ClassNotFoundException {
        Connection connect = Dbconnection.getObject().getConnection();
        Statement stmt = connect.createStatement();
        String sql = "SELECT\n" +
                "    worker_id AS id,\n" +
                "    worker_name AS name,\n" +
                "    worker_number AS number,\n" +
                "    system_user_Roll AS role,\n" +
                "    email\n" +
                "FROM worker\n" +
                "\n" +
                "UNION ALL\n" +
                "\n" +
                "SELECT\n" +
                "    coach_id AS id,\n" +
                "    coach_name AS name,\n" +
                "    coach_number AS number,\n" +
                "    system_user_Roll AS role,\n" +
                "    email\n" +
                "FROM coaches;";
        ResultSet rsp = stmt.executeQuery(sql);
        String id ="Employee not found";
        while (rsp.next()){
            String system_user_id = rsp.getString("id");
            if(system_user_id.equals(employeeId)){
                id ="Employee avelable :"+ system_user_id;
            }

        }
        return id;

    }
}
