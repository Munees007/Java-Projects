package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("index.html");
            return;
        }

        String user = session.getAttribute("user").toString();
        
        // Log the dashboard request
        System.out.println("======== DASHBOARD SERVLET REQUEST ========");
        System.out.println("User: " + user);
        System.out.println("Request Type: GET /dashboard");
        System.out.println("Timestamp: " + new java.util.Date());
        System.out.println("===========================================");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><head>");
        out.println("<title>Dashboard</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>Dashboard</h1>");
        out.println("<p>Welcome <b>" + user + "</b></p>");
        out.println("<p>Auto logout in 5 seconds</p>");

        out.println("<form action='logout' method='post'>");
        out.println("<button type='submit'>Logout</button>");
        out.println("</form>");

        out.println("<script>");
        out.println("setTimeout(function() {");
        out.println("  fetch('logout', { method: 'POST' })");
        out.println("    .then(() => window.location.href = 'index.html');");
        out.println("}, 5000);");
        out.println("</script>");

        out.println("</body></html>");
    }
}
