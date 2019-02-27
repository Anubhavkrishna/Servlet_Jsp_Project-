package test_database;
import java.sql.*;

public class Check {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/employee";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "password-1";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql,sql1;
      sql1="Insert into employee (id,name,address) values()   ";
      sql = "SELECT id, name, address FROM employee";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         //int age = rs.getInt("age");
         String name = rs.getString("name");
         String address = rs.getString("address");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Name: " + name);
         System.out.println(", Address: " + address);
         //System.out.println(", Last: " + last);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      }
      // nothing we can do
      //end finally try
   //end try
   System.out.println("Goodbye!");
}
 }
