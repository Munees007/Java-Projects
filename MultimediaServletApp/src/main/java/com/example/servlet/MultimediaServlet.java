package com.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/media")
public class MultimediaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String type = req.getParameter("type");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Media Output</title>");
        out.println("<script src='https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4'></script>");
        out.println("</head>");

        out.println("<body class='min-h-screen flex items-center justify-center bg-gray-100'>");
        out.println("<div class='bg-white p-8 rounded-xl shadow-lg w-full max-w-sm text-center'>");

        out.println("<h1 class='text-2xl font-bold text-indigo-600 mb-4'>Media Output</h1>");

        if ("image".equals(type)) {
            out.println("<img src='Logo.png' class='mx-auto rounded-lg' width='300' />");
        }
        else if ("audio".equals(type)) {
            out.println("<audio controls class='mx-auto'>");
            out.println("<source src='audio.mpeg' type='audio/mpeg'>");
            out.println("</audio>");
        }
        else if ("video".equals(type)) {
            out.println("<video controls width='300' class='mx-auto rounded-lg'>");
            out.println("<source src='video.mp4' type='video/mp4'>");
            out.println("</video>");
        }

        out.println("<a href='index.html' class='inline-block mt-6 px-6 py-2 " +
                "bg-indigo-600 text-white rounded-lg hover:bg-indigo-700'>Back</a>");

        out.println("</div></body></html>");
    }
}
