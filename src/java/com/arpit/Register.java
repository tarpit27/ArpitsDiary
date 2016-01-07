
package com.arpit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arpit
 */
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        String fullName = request.getParameter("regName");
        String username = request.getParameter("regUsername");
        String email = request.getParameter("regEmail");
        String password = request.getParameter("regPassword");
        
        if( com.arpit.classes.RegisterDAO.write(fullName, username, email, password) ){
            response.sendRedirect("index.html");
        } else{
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.print("Something went wrong!<br>Unable to register!");
        }
    }

}
