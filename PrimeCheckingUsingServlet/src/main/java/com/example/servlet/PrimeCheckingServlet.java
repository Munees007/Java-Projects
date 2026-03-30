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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        
        // Log the user request
        System.out.println("======== PRIME CHECKING SERVLET REQUEST ========");
        System.out.println("Number to Check: " + num);
        System.out.println("Request Type: POST /prime");
        System.out.println("Timestamp: " + new java.util.Date());
        System.out.println("===============================================");
        
        String result = "Prime Number";
        for(int i = 2;i<=num/2;i++)
        {
            if(num % i == 0)
            {
                result = "Not a Prime Number";
                break;
            }
        }
        
        // Log the result
        System.out.println("Result: " + result);
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Result</h2>");
        out.println("<p>" + result + "</p>");
        out.println("<a href='index.html'>Check Another</a>");
        out.println("</body></html>");
    }
}
