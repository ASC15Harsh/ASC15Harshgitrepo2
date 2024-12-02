package jdbc;

import java.sql.*;
import java.util.Scanner;

public class operations {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 to Read");
            System.out.println("Press 2 to Create");
            System.out.println("Press 3 to Update");
            System.out.println("Press 4 to Delete");
            System.out.println("Press 5 to exit");
            System.out.println("Enter the choice");
            choice = scanner.nextInt();

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb1", "root", "mysql");
                Statement statement = connection.createStatement();
                switch (choice) {
                    case 1:
                        System.out.println("Read Operation");
                        ResultSet resultSet = statement.executeQuery("select * from user");
                        while (resultSet.next()) {
                            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getString(4));
                        }
                        break;
                    case 2:
                        System.out.println("Create Operation");
//                        System.out.print("Enter user_id: ");
//                        int userId = scanner.nextInt();
                        System.out.print("Enter email: ");
                        String email = scanner.next();
                        System.out.print("Enter first name: ");
                        String firstName = scanner.next();
                        System.out.print("Enter last name: ");
                        String lastName = scanner.next();
                        ResultSet rs = statement.executeQuery("SELECT MAX(id) AS max_id FROM user");
                        int newUserId = 1;
                        if (rs.next()) {
                            newUserId = rs.getInt("max_id") + 1;
                        }
                        int InsertSet = statement.executeUpdate("insert into user values (" + newUserId + ", '" + email + "', '" + firstName + "', '" + lastName + "')");
                        System.out.println(InsertSet + " inserted!");
                        break;
                    case 3:
                        System.out.println("Update Operation");
                        System.out.println("Enter the User Id");
                        int uuid = scanner.nextInt();
                        System.out.print("Enter email: ");
                        String uemail = scanner.next();
                        System.out.print("Enter first name: ");
                        String ufirstName = scanner.next();
                        System.out.print("Enter last name: ");
                        String ulastName = scanner.next();
                        int UpdateSet = statement.executeUpdate("UPDATE user SET email = '" + uemail + "', first_name = '" + ufirstName + "', last_name = '" + ulastName + "' WHERE id = " + uuid);
                        System.out.println(UpdateSet + " updated!");
                        break;
                    case 4:
                        System.out.println("Delete Operation");
                        System.out.print("Enter user_id to delete: ");
                        int userIdToDelete = scanner.nextInt();
                        int DeleteSet = statement.executeUpdate("delete from user  where id = " + userIdToDelete);
                        System.out.println(DeleteSet + " deleted!");
                        break;
                    case 5:
                        System.out.println("Thank you !");
                        return;
                    default:
                        System.out.println("wrong Input");

                }
            } catch (SQLException exception) {
                System.out.println("Error: Could not connect to the database." + exception.getMessage());
            }
        }
    }
}
