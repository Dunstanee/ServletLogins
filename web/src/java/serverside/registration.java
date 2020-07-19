/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MR DUNSTAN
 */
@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class registration extends HttpServlet {

DatabaseConnection DC = new DatabaseConnection();
    ResultSet rs;
    Connection conn;
    Statement st;
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               conn = DC.getConnection();
        
        String username = request.getParameter("username").toUpperCase();
      
        String password = request.getParameter("password");
        int encryptedpass = password.hashCode();
        String pass = String.valueOf(encryptedpass);
if(username.equals("")  ||password.equals("") ){
   
}else{
        String query = "INSERT INTO users VALUES(0,'" + username.trim() + "','" + pass.trim() + "')";
        try {
            st = (Statement) conn.createStatement();
            st.executeUpdate(query);
            st.close();
           } catch (SQLException ex) {
           
        }
      response.sendRedirect("index.html"); 
}
    }


   
}
