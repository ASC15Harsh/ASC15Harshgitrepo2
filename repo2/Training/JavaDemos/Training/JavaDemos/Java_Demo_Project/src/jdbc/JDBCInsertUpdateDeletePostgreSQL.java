package jdbc;


import java.sql.*;

public class JDBCInsertUpdateDeletePostgreSQL {
    public static void main(String[] args) {
        Connection connection =null;
        try {
            System.out.println("Driver Loaded!");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb1", "root", "mysql");
            System.out.println("Connection established!");
            Statement  statement = connection.createStatement();
            System.out.println("Statement created");
            ResultSet resultSet = statement.executeQuery("select * from user");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString("first_name") + "\t" + resultSet.getString("last_name"));
            }

//             int noOfRows = statement.executeUpdate("insert into user values (102,'abc@c.com','Rohit','TheMaster')");
//             System.out.println(noOfRows + " inserted!");

            // int noOfRows = statement.executeUpdate("update user set email = 'newmail@nm.com'");
//             int noOfRows = statement.executeUpdate("update user set email = 'NEW@r.com' , first_name ='R' where user_id = 102");
//             		System.out.println(noOfRows + " updated!");
//
//            int noOfRows = statement.executeUpdate("delete from user  where user_id = 102 ");
//            System.out.println(noOfRows + " deleted!");


        }
        catch (SQLException sqlException) {
            System.out.println("Error processing db operation!" + sqlException.getMessage());
        }
        finally {
            try {
                connection.close();
            } catch (SQLException sQLException) {
                System.out.println("Unable to close the connection" + sQLException.getMessage());
            }
            System.out.println("Connection closed successfully!");
        }

    }
}