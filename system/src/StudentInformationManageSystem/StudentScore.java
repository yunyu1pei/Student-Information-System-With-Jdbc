package StudentInformationManageSystem;

import java.sql.*;
import java.util.Scanner;

public class StudentScore {
    public static void score() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bookstore?useSSL=false";
            String name = "root";
            String password = "ertyfgh789";
            connection = DriverManager.getConnection(url, name, password);
            Statement stmt = connection.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("请输入学生姓名：");
            String stuname = input.next();
            System.out.println("请输入课程名：");
            String coursename = input.next();
            String sql = "select 成绩 from score where 学号 = any (select 学号 from student where 姓名 = '"+stuname+"')and" +
                    " 课程号 = any (select 课程号 from course where 课程名 = '"+coursename+"')";
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                int score = resultSet.getInt("成绩");
                System.out.println("----------------");
                System.out.println("成绩："+score);
                System.out.println("----------------");
            }
        } catch (SQLException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }
}