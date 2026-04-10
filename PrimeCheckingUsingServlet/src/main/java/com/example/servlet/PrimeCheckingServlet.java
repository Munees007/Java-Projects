package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prime")
public class PrimeCheckingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            int num = Integer.parseInt(req.getParameter("num"));

            System.out.println("======== PRIME CHECKING SERVLET REQUEST ========");
            System.out.println("Number to Check: " + num);
            System.out.println("Request Type: POST /prime");
            System.out.println("Timestamp: " + new java.util.Date());
            System.out.println("===============================================");

            String result = isPrime(num) ? "Prime Number" : "Not a Prime Number";
            System.out.println("Result: " + result);

            out.println("<html><body>");
            out.println("<h2>Result</h2>");
            out.println("<p>" + num + " is " + result + "</p>");
            out.println("<a href='index.html'>Check Another</a>");
            out.println("</body></html>");
        } catch (NumberFormatException ex) {
            out.println("<html><body>");
            out.println("<h2>Invalid Input</h2>");
            out.println("<p>Please enter a valid whole number.</p>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
