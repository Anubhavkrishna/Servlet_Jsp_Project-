package test_database;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class Product extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
      // JDBC driver name and database URL
      final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      final String DB_URL="jdbc:mysql://localhost:3306/employee";

      //  Database credentials
      final String USER = "root";
      final String PASS = "password-1";
         Connection conn=null;
         PreparedStatement stmt=null;
         Statement stmt1=null;
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
           
      try {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         conn = DriverManager.getConnection(DB_URL, USER, PASS);    
         stmt=conn.prepareStatement("insert into product values(?,?,?,?)");
         String  product_id=request.getParameter("product_id");
         String category=request.getParameter("product");
         String product_name=request.getParameter("product_name");
         String price=request.getParameter("price");
         int p=Integer.parseInt(product_id);
         int pr=Integer.parseInt(price);
         
         stmt.setInt(1,p);
         stmt.setString(2,category);
         stmt.setString(3,product_name);
         stmt.setInt(4,pr);
                 
         stmt.executeUpdate();
         
         stmt1=conn.createStatement();
         String sql="Select * from product ";
        ResultSet rs= stmt1.executeQuery(sql);
        while(rs.next()){
        	String s1=rs.getString("product_id");
        	String s2=rs.getString("category");
        	String s3=rs.getString("name");
        	String s4=rs.getString("price");
        	
        	
        	out.println(s1);
        	out.println(s2);
        	out.println(s3);
        	out.println(s4);
        	out.println();  	
        }
         
         
         
         
          
         stmt.close();
         conn.close();
      } catch(SQLException se) {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally {
         //finally block used to close resources
         try {
            if(stmt!=null)
               stmt.close();
         } catch(SQLException se2) {
         } // nothing we can do
         try {
            if(conn!=null)
            conn.close();
         } catch(SQLException se) {
            se.printStackTrace();
         } //end finally try
      } //end try
   }
} 