
package com.arpit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arpit
 */
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        session.invalidate();
        System.out.println("Session is deleted.");
        Cookie ck = new Cookie("user", "");
        ck.setMaxAge(0);
        response.addCookie(ck);
        response.sendRedirect("index.html");
        System.out.println("Cookie is deleted.");
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

}
