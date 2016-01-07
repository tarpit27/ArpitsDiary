
package com.arpit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
public class Login extends HttpServlet {

    private void createSession(HttpServletRequest request, HttpServletResponse response, String user) {
        HttpSession session = request.getSession();
        session.setAttribute("username", user);
    }

    private void setCookie(HttpServletRequest request, HttpServletResponse response, String user) {
        Cookie ck = new Cookie("user", user);
        ck.setMaxAge(7*24*60*60);
        response.addCookie(ck);
        System.out.println("Cookie is set for " + (ck.getMaxAge())/(60*60*24) + " days.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        com.arpit.classes.UserModel bean = new com.arpit.classes.UserModel();

        bean.setUsername(user);
        bean.setPassword(password);

        bean = com.arpit.classes.LoginDAO.status(bean);
        if (bean.getIsValid()) {
            createSession(request, response, user);
            if (remember!=null) {
                setCookie(request, response, user);
            }
            response.sendRedirect("welcome.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.print("Invalid login credentials!");
            request.getRequestDispatcher("index.html").include(request, response);
        }
    }
}
