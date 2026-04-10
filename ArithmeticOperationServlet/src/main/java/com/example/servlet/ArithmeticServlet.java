package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/arithmetic")
public class ArithmeticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            int a = Integer.parseInt(req.getParameter("a"));
            int b = Integer.parseInt(req.getParameter("b"));
            String result = "Addition = " + (a + b);

            System.out.println("======== ARITHMETIC SERVLET REQUEST ========");
            System.out.println("Operation: Addition");
            System.out.println("Number 1 (a): " + a);
            System.out.println("Number 2 (b): " + b);
            System.out.println("Request Type: POST /arithmetic");
            System.out.println("Timestamp: " + new java.util.Date());
            System.out.println("============================================");
            System.out.println(result);

            out.println("<html><body>");
            out.println("<h2>Result</h2>");
            out.println("<p>" + result + "</p>");
            out.println("<a href='index.html'>Back</a>");
            out.println("</body></html>");
        } catch (NumberFormatException ex) {
            out.println("<html><body>");
            out.println("<h2>Invalid Input</h2>");
            out.println("<p>Please enter valid numbers in both fields.</p>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }
}
