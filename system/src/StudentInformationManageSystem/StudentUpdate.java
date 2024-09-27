package StudentInformationManageSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentUpdate {
    public static void update(){
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bookstore?useSSL=false";
            String name = "root";
            String password = "ertyfgh789";
            connection = DriverManager.getConnection(url, name, password);
            Statement stmt = connection.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("请输入要修改学生的学号:");
            int id = input.nextInt();
            System.out.println("请输入要修改的列:");
            String colum = input.next();
            System.out.println("请输入要修改的值:");
            String value = input.next();
            String sql = "UPDATE bookstore.student SET " + colum + " = '" + value + "' WHERE 学号 = " + id;
            stmt.executeUpdate(sql);
            System.out.println("学生修改成功！");
            stmt.close();
            connection.close();
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}