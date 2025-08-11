package edu.lk.ijse.projectgym.demo76promax.dao.custom.impl;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;
import edu.lk.ijse.projectgym.demo76promax.Dtos.SuplayerDto;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.SuplayersDAO;
import edu.lk.ijse.projectgym.demo76promax.entity.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuplayersDAOImpl implements SuplayersDAO {

    @Override
    public List<Suppliers> getAll() throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "SELECT ALL  * FROM suppliers";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
       List<Suppliers> list = new ArrayList<>();

        while (resultSet.next()){

            Suppliers entyty = new Suppliers(
                    resultSet.getString("supplier_id"),
                    resultSet.getString("name"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getString("address")
            );
            list.add(entyty);
        }
        return list;
    }

    @Override
    public Boolean delete(String id) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "DELETE FROM suppliers WHERE supplier_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        int i = preparedStatement.executeUpdate();
        return i > 0;

    }

    @Override
    public Boolean update(Suppliers suppliers) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "UPDATE suppliers SET name =?,phone = ?,email = ?,address = ? WHERE supplier_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, suppliers.getName());
        preparedStatement.setString(2, suppliers.getContactNumber());
        preparedStatement.setString(3, suppliers.getEmail());
        preparedStatement.setString(4, suppliers.getAddress());
        preparedStatement.setString(5, suppliers.getSupplierId());
        int i = preparedStatement.executeUpdate();
        return i>0;
    }

    @Override
    public Boolean save(Suppliers suppliers) throws ClassNotFoundException, SQLException {
        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "INSERT INTO suppliers VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, suppliers.getSupplierId());
        preparedStatement.setString(2, suppliers.getName());
        preparedStatement.setString(3, suppliers.getContactNumber());
        preparedStatement.setString(4, suppliers.getEmail());
        preparedStatement.setString(5, String.valueOf(suppliers.getAddress()));

        int i = preparedStatement.executeUpdate();
       return  i > 0;
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
