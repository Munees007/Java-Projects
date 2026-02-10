package com.example.servlet;
import javax.servlet.annotation.WebServlet;
import  javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletResponse;
import  javax.servlet.http.HttpServletRequest;
import  java.io.*;
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("name");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h1 style='text-align:center;color:green;'>Welcome " + name + "!</h1>");
    }
}

