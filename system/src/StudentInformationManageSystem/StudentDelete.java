package StudentInformationManageSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDelete {
    public static void delete(){
        Connection connection;
        try {
            String url = "jdbc:mysql://localhost:3306/bookstore?useSSL=false";
            String name = "root";
            String password = "ertyfgh789";
            connection = DriverManager.getConnection(url, name, password);
            Statement stmt = connection.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("请输入要删除的学号:");
            int id = input.nextInt();
            String sql = "delete from bookstore.student where 学号 = " + id;
            stmt.executeUpdate(sql);
            System.out.println("学生删除成功！");
            stmt.close();
            connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}