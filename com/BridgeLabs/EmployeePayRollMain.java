package com.BridgeLabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeePayRollMain {
    static  final String DB_URL = "jdbc:mysql://localhost:3306/payroll_servicees";
    static final String USERNAME = "root";
    static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = null;
            stmt = connection.createStatement();
//            boolean val = stmt.execute("show databases");
//            int count = stmt.executeUpdate("insert into employee_payroll(name,salary,start)values(\"Divya\",1000,'2020-01-2'),(\"Lohith\",60000,'2020-08-22'),(\"Prathmesh\",600,'2020-08-23')");
//            System.out.println(count+"Employee inserted successfully");
//            int isupdated = stmt.executeUpdate("alter table employee_payroll add gender varchar(20) after name");
//            System.out.println(isupdated);
//            stmt.executeUpdate("update employee_payroll set gender = 'f' where name = 'Divya'");
//            stmt.executeUpdate("update employee_payroll set gender = 'm' where name = 'Lohith'");
//            stmt.executeUpdate("update employee_payroll set gender = 'm' where name = 'Prathmesh'");
////            ((Statement) stmt).executeUpdate("CREATE TABLE employee_payroll (id int not null auto_increment,name varchar(30) not null,salary double not null,start date not null,primary key(id))");
////            System.out.println("Created table in given database...");
////            System.out.println("Showing data present in the table");
//            boolean val = stmt.execute("select * from emp_payroll  where name = 'Lohith'");
//            System.out.println(val);
            boolean val = stmt.execute("select * from employee_payroll");
            if (val){
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    // Retrieve by column name
                    System.out.print("ID: " + rs.getInt("id"));
                    System.out.print(", Name: " + rs.   getString("name"));
                    System.out.print(", gender: " + rs.   getString("gender"));
                    System.out.print(", Salary: " + rs.getDouble("salary"));
                    System.out.print(", Date: " + rs.getDate("start"));
                    System.out.print(", Phno: " + rs.getInt("phonenumber"));
                    System.out.print(", address: " + rs.   getString("address"));
                    System.out.print(", department: " + rs.   getString("department"));
                    System.out.println();
                }
            }else {
                int count2=stmt.getUpdateCount();
                System.out.println(count2);
            }
            int isupdated = stmt.executeUpdate("alter table employee_payroll add phonenumber int after start");
            int isupdated1 = stmt.executeUpdate("alter table employee_payroll add address varchar(100) after phonenumber");
            int isupdated2 = stmt.executeUpdate("alter table employee_payroll add department varchar(50) after salary");
            System.out.println(isupdated1);
            System.out.println(isupdated2);
            stmt.executeUpdate("update employee_payroll set phonenumber = 987648 where name = 'Lohith'");
            stmt.executeUpdate("update employee_payroll set phonenumber = 649875 where name = 'Divya'");
            stmt.executeUpdate("update employee_payroll set phonenumber = 654321 where name = 'Prathmesh'");
            stmt.executeUpdate("update employee_payroll set phonenumber = 765778 where name = 'Swathi'");
            stmt.executeUpdate("update employee_payroll set phonenumber = 675456 where name = 'Ravali'");
            stmt.executeUpdate("update employee_payroll set address = 'Hyderbad' ,department='sales' where id = 1");
            stmt.executeUpdate("update employee_payroll set address = 'Delhi' ,department='teamlead' where id = 2");
            stmt.executeUpdate("update employee_payroll set address = 'Chennai' ,department='manager' where id = 3");
            stmt.executeUpdate("update employee_payroll set address = 'Bengaluru' ,department='marketing' where id = 4");
            stmt.executeUpdate("update employee_payroll set address = 'solapur' ,department='HR' where id = 5");
        } catch (Exception e){
            e.printStackTrace();
        }





    }
}
