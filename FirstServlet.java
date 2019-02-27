package test_database;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class FirstServlet extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
      // JDBC driver name and database URL
      final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      final String DB_URL="jdbc:mysql://localhost:3306/employee";

      //  Database credentials
      final String USER = "root";
      final String PASS = "password-1";
         Connection conn=null;
         Statement stmt=null;
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
     
      try {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         stmt = conn.createStatement();
         
         String sql;
         sql = "SELECT username,password,status FROM employee";
         ResultSet rs = stmt.executeQuery(sql);
         String name1=request.getParameter("email");
         String pass=request.getParameter("password");
        

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            String user  = rs.getString("username");
            String password = rs.getString("password");
            if((name1.equals(user)) &&(pass.equals(password))){          	  
                 HttpSession session=request.getSession();  
                 session.setAttribute("name",user); 
                 session.setAttribute("password",password);
                 request.setAttribute("name1",user);
                 request.getRequestDispatcher("welcome.jsp").forward(request,response);
                }  
                else{
                	String sql1="select status from employee where id=100";
                    ResultSet rs1=stmt.executeQuery(sql1);
                    rs1.next();
                	 int a=rs1.getInt("status");
                	 a=a+1;
                        	    
                	 String sql2="Update employee set status="+ a +" where id=100";

                	 stmt.executeUpdate(sql2);
                      if(a>3)
                    	  out.println("Your account has been blocked..please contact admin");
                      else{
                    out.print("Sorry, username or password error!");  
                    request.getRequestDispatcher("index.html").include(request, response);  
                           }
                                            
                      }
         }
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
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