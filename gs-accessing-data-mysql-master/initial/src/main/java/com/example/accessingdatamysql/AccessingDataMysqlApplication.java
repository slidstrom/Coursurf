package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;

@SpringBootApplication
public class AccessingDataMysqlApplication {

    // public static void main(String[] args) {
			//public class JDBCExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   // original: static final String DB_URL = "jdbc:mysql://localhost/";
	 static final String DB_URL = "jdbc:mysql://localhost:3306?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "fse";

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();

      stmt.executeUpdate("DROP DATABASE IF EXISTS db_example;");
      stmt.executeUpdate("DROP USER IF EXISTS 'springuser'@'localhost';");



      String sql = "CREATE DATABASE db_example;";
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");

			sql = "CREATE USER 'springuser'@'localhost' IDENTIFIED BY 'fse';";
			stmt.executeUpdate(sql);
			System.out.println("Created DB USER 'springuser@localhost'");

			sql = "grant all on db_example.* to 'springuser'@'localhost';";
			stmt.executeUpdate(sql);
			System.out.println("Success");

   } catch(Exception se){
      //Handle errors for JDBC
      se.printStackTrace();
   }//Handle errors for Class.forName
   finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2) {
         se2.printStackTrace();
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
   
   SpringApplication.run(AccessingDataMysqlApplication.class, args);
}//end main
}//end JDBCExample

            //SpringApplication.run(AccessingDataMysqlApplication.class, args);
  //  }
// }
