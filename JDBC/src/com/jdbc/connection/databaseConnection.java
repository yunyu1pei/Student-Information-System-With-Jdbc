package com.jdbc.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class databaseConnection {
    public static void conn(){
        Connection connection;
        String url = "jdbc:mysql://localhost:3306/bookstore";   //数据库连接的url地址
        String user = "root";   //数据库用户名
        String password = "ertyfgh789";  //数据库密码
        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功！");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            //通过DriverManager获取数据库连接
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接成功！");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        databaseConnection.conn();   //静态方法：直接使用类名.方法名调用
    }
}
