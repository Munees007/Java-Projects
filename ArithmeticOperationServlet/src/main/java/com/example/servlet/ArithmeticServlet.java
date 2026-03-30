package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/arithmetic")
public class ArithmeticServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        String op = req.getParameter("op");

        // Log the user request
        System.out.println("======== ARITHMETIC SERVLET REQUEST ========");
        System.out.println("Operation: Addition");
        System.out.println("Number 1 (a): " + a);
        System.out.println("Number 2 (b): " + b);
        System.out.println("Request Type: POST /arithmetic");
        System.out.println("Timestamp: " + new java.util.Date());
        System.out.println("============================================");

        String result = "Addition = " + (a + b);
        System.out.println(result);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Result</h2>");
        out.println("<p>" + result + "</p>");
        out.println("<a href='index.html'>Back</a>");
        out.println("</body></html>");
    }
}
