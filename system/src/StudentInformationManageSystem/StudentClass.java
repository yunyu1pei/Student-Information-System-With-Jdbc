package StudentInformationManageSystem;

import java.sql.*;
import java.util.Scanner;

public class StudentClass {
    public static void stuclass() {
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
            String sql = "select * from bookstore.class where 班级编号 = (select 班级编号 from bookstore.student where 姓名 = '"+stuname+"')";
            ResultSet resultSet = stmt.executeQuery(sql);
            System.out.println("班级编号     |     班级名称     |     院系     |     年级     |     人数     |");
            while (resultSet.next()){
                String classid = resultSet.getString("班级编号");
                String classname = resultSet.getString("班级名称");
                String college= resultSet.getString("院系");
                String grade = resultSet.getString("年级");
                String popluations = resultSet.getString("人数");
                System.out.println(classid+"   |   "+classname+"   |" +
                        "   "+college+"   |   "+grade+"   |   "+popluations+"   |   ");
            }
            stmt.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }
}