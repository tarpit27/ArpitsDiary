
package com.arpit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arpit
 */
public class Edit extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String newDiary = request.getParameter("newDiary");
        HttpSession session = request.getSession(false);
        String username = (String)session.getAttribute("username");
        boolean isUpdate = com.arpit.classes.EditDAO.editDiary(title, username, newDiary);
        if(isUpdate){
            response.sendRedirect("welcome.jsp");
        }
    } //[end doPost]
} //[end class]
