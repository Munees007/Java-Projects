package com.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        // simple validation (demo purpose)
        if (user.equals("Munees") && pass.equals("Munees@123")) {

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // Auto logout after 5 seconds inactivity
            session.setMaxInactiveInterval(5);

            resp.sendRedirect("dashboard");
        } else {
            resp.getWriter().println("Invalid Login");
        }
    }
}
