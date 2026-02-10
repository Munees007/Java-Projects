package com.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/arithmetic")
public class ArithmeticServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));
        String op = req.getParameter("op");

        String result = "";

        switch (op) {
            case "add":
                result = "Addition = " + (a + b);
                break;

            case "sub":
                result = "Subtraction = " + (a - b);
                break;

            case "mul":
                result = "Multiplication = " + (a * b);
                break;

            case "div":
                if (b == 0) {
                    result = "Cannot divide by zero";
                } else {
                    result = "Division = " + (a / b);
                }
                break;
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Result</title>");
        out.println("<script src='https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4'></script>");
        out.println("</head>");

        out.println("<body class='min-h-screen flex items-center justify-center bg-gray-100'>");
        out.println("<div class='bg-white p-8 rounded-xl shadow-lg w-full max-w-sm text-center'>");

        out.println("<h1 class='text-2xl font-bold text-indigo-600 mb-4'>Result</h1>");
        out.println("<p class='text-xl font-semibold text-gray-800'>" + result + "</p>");

        out.println("<a href='index.html' class='inline-block mt-6 px-6 py-2 " +
                "bg-indigo-600 text-white rounded-lg hover:bg-indigo-700'>Back</a>");

        out.println("</div></body></html>");
    }
}
