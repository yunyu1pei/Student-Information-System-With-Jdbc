package StudentInformationManageSystem;

import java.sql.*;

public class StudentQuery {
    public static void query(){
        Connection connection;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/bookstore?useSSL=false";
            String name = "root";
            String password = "ertyfgh789";
            connection = DriverManager.getConnection(url,name,password);
            Statement stmt = connection.createStatement();
            String sql = "select * from student";
            ResultSet resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("学号");
                String Studentname = resultSet.getString("姓名");
                String gender = resultSet.getString("性别");
                String brithday = resultSet.getString("出生日期");
                String area = resultSet.getString("地区");
                String nation = resultSet.getString("民族");
                String classId = resultSet.getString("班级编号");
                System.out.println("学号:"+id+"  姓名:"+Studentname+" 性别:"+gender+" 出生日期:"
                        +brithday+" 地区:"+area+" 民族:"+nation+" 班级编号:"+classId);
            }
            stmt.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);

        }
    }
}