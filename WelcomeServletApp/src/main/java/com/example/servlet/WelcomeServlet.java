package com.example.servlet;
import javax.servlet.annotation.WebServlet;
import  javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletResponse;
import  javax.servlet.http.HttpServletRequest;
import  java.io.*;
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("name");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (name == null || name.trim().isEmpty()) {
            out.println("<html><body>");
            out.println("<h2>Name Required</h2>");
            out.println("<p>Please enter your name before submitting.</p>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }

        String safeName = name.trim()
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");

        System.out.println("Client: " + safeName);
        out.println("<html><body>");
        out.println("<h1 style='text-align:center;color:green;'>Welcome " + safeName + "!</h1>");
        out.println("<p style='text-align:center;'><a href='index.html'>Back</a></p>");
        out.println("</body></html>");
    }
}

