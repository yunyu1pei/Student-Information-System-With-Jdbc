package StudentInformationManageSystem;

import java.sql.*;
import java.util.Scanner;

public class StudentCourse {
    public static void course() {
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
            String sql = "select * from bookstore.course where 课程号 =" +
                    " any (select 课程号 from bookstore.score where 学号 = any (select 学号 from bookstore.student where 姓名 = '"+stuname+"'))";
            ResultSet resultSet = stmt.executeQuery(sql);
            System.out.println("课程号   |   课程名   |   学分   |   学时   |   学期   |");
            while (resultSet.next()){
                String coureid = resultSet.getString("课程号");
                String courename = resultSet.getString("课程名");
                String score = resultSet.getString("学分");
                String time = resultSet.getString("学时");
                String term = resultSet.getString("学期");
                System.out.println(coureid+"   |   "+courename+"   |   "+score+"   |   "+time+"   |   "+term+"   |   ");
            }
            stmt.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }
}