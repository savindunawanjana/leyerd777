package edu.lk.ijse.projectgym.demo76promax.dao.util;

import edu.lk.ijse.projectgym.demo76promax.Dbconnection.Dbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Publicforcoachandclener {
    
    public static Boolean shouldBeRunThisMethod() throws SQLException, ClassNotFoundException {

        Connection connection = Dbconnection.getObject().getConnection();
        String sql = "INSERT INTO employees_table (id, name, number, role, email)\n" +
                "SELECT w.worker_id, w.worker_name, w.worker_number, w.system_user_Roll, w.email\n" +
                "FROM worker w\n" +
                "WHERE NOT EXISTS (\n" +
                "    SELECT 1 FROM employees_table e WHERE e.id = w.worker_id\n" +
                ")\n" +
                "\n" +
                "UNION ALL\n" +
                "\n" +
                "SELECT c.coach_id, c.coach_name, c.coach_number, c.system_user_Roll, c.email\n" +
                "FROM coaches c\n" +
                "WHERE NOT EXISTS (\n" +
                "    SELECT 1 FROM employees_table e WHERE e.id = c.coach_id\n" +
                ")";

        Statement statement = connection.createStatement();
        int rowsInserted = statement.executeUpdate(sql);
        System.out.println("rowsInserted = " + rowsInserted);
//connection.rollback();
        return rowsInserted > 0 ? true : false;

    }

}
