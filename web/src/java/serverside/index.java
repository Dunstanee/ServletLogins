/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MR DUNSTAN
 */
@WebServlet(name = "index", urlPatterns = {"/index"})
public class index extends HttpServlet {
DatabaseConnection DC = new DatabaseConnection();
    ResultSet rs;
    Connection conn;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       conn = DC.getConnection();
        String password = request.getParameter("password");
        int encryptedpass = password.hashCode();
        String pass = String.valueOf(encryptedpass);
        String username = request.getParameter("username");
        
        try{
           
           String query = "SELECT * FROM users WHERE user_name='"+username.toLowerCase().trim()+"'AND user_password='"+pass+"'";
           rs = conn.createStatement().executeQuery(query);
           if(rs.next()){
            
               HttpSession session = request.getSession();
               session.setAttribute("username", rs.getString("user_name"));
               
               session.setAttribute("userid", rs.getString("user_id"));
               response.sendRedirect("Dashboard.html");
           }else{
               
                response.sendRedirect("register.html");
           }
        }catch(SQLException e){
            
        }
        
    }


}
