
package com.arpit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arpit
 */
public class Write extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("write.jsp");
        
        String writeTitle, writeDate, writeDiary;
        writeTitle = request.getParameter("writeTitle");
        writeDate = request.getParameter("writeDate");
        writeDiary = request.getParameter("writeDiary");
        
        HttpSession session = request.getSession(false);
        String username = (String)session.getAttribute("username");
        
        boolean isWritten = com.arpit.classes.WriteDao.writeData(writeTitle, writeDate, writeDiary, username);
        if(isWritten){
            response.sendRedirect("welcome.jsp");
        } else{
            out.print("Something went wrong!<br>Unable to wirte!");
        }
    }


}
