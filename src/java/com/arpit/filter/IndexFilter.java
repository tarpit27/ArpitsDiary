
package com.arpit.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arpit
 */
public class IndexFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String user = null;

        Cookie[] ck = req.getCookies();
        if (ck != null) {
            for (Cookie c : ck) {
                System.out.println(c.getName() + ": " + c.getValue());
                if (c.getName().equals("user")) {
                    user = c.getValue();
                }
            }
        } else {
            System.out.println("Cookie[] is null");
        }

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user);
            res.sendRedirect("welcome.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {

    }

}
