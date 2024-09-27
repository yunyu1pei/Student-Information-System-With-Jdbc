package StudentInformationManageSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentAdd {
    public static void add() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bookstore?useSSL=false";
            String name = "root";
            String password = "ertyfgh789";
            connection = DriverManager.getConnection(url, name, password);
            Statement stmt = connection.createStatement();

            Scanner input = new Scanner(System.in);
            System.out.println("请输入学号：");
            int id = input.nextInt();
            System.out.println("请输入姓名：");
            String studnetname = input.next();
            System.out.println("请输入性别：");
            String gender = input.next();
            System.out.println("请输入出生日期：");
            String brithday = input.next();
            System.out.println("请输入地区：");
            String area = input.next();
            System.out.println("请输入民族：");
            String nation = input.next();
            System.out.println("请输入班级编号：");
            String classId = input.next();
            String sql = "insert into bookstore.student(学号, 姓名, 性别, 出生日期, 地区, 民族, 班级编号) " +
                    "values(" + id + ",'" + studnetname + "','" + gender + "','" + brithday + "','" + area + "','" + nation + "','" + classId + "') ";
            stmt.executeUpdate(sql);
            System.out.println("学生添加成功！");
            stmt.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }
}