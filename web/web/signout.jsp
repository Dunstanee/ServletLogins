<%-- 
    Document   : signout
    Created on : Jul 3, 2020, 11:18:33 AM
    Author     : MR DUNSTAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loading ... </title>
    </head>
    <body>
            <%
           // this is used to destroy the session
      session.invalidate();
      //this is used to redirect the page to home page
      response.sendRedirect("index.html");
       %>
    </body>
</html>
