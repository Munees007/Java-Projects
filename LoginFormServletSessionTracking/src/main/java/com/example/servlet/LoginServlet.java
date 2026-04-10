package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        
        // Log the user request
        System.out.println("======== LOGIN SERVLET REQUEST ========");
        System.out.println("Username: " + user);
        System.out.println("Request Type: POST /login");
        System.out.println("Timestamp: " + new java.util.Date());
        System.out.println("========================================");

        // simple validation (demo purpose)
        if ("Munees".equals(user) && "Munees@123".equals(pass)) {
            
            // Log successful login
            System.out.println("Login Status: SUCCESS");
            System.out.println("Session created for user: " + user);

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // Auto logout after 5 seconds inactivity
            session.setMaxInactiveInterval(5);

            resp.sendRedirect("dashboard");
        } else {
            // Log failed login
            System.out.println("Login Status: FAILED - Invalid credentials");
            
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h2>Invalid Login</h2>");
            out.println("<p>Username or password is incorrect!</p>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }
}
