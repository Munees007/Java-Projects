package com.welcome;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/add")
public class Handler extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String name = request.getParameter("name");
        System.out.println("IP = " + request.getRemoteAddr());
        System.out.println("Name = " + name);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<p>Fuck Servlet<p>");
    }
}
