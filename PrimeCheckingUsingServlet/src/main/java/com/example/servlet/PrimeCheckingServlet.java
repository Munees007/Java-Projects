package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/prime")
public class PrimeCheckingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        String result = "Prime Number";
        for(int i = 2;i<=num/2;i++)
        {
            if(num % i == 0)
            {
                result = "Not a Prime Number";
                break;
            }
        }
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Prime Result</title>");
        out.println("<script src='https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4'></script>");
        out.println("</head>");

        out.println("<body class='min-h-screen flex items-center justify-center bg-gray-100'>");

        out.println("<div class='bg-white p-8 rounded-xl shadow-lg w-full max-w-sm text-center'>");

        out.println("<h1 class='text-2xl font-bold text-indigo-600 mb-4'>Result</h1>");

        if (result.equals("Prime Number")) {
            out.println("<p class='text-2xl font-bold text-green-600'>" + result + "</p>");
        } else {
            out.println("<p class='text-2xl font-bold text-red-600'>" + result + "</p>");
        }

        out.println("<a href='index.html' " +
                "class='inline-block mt-6 px-6 py-2 bg-indigo-600 text-white rounded-lg " +
                "hover:bg-indigo-700 transition'>Check Another</a>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }
}
