package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/media")
public class MultimediaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String type = req.getParameter("type");
        
        // Log the user request
        System.out.println("======== MULTIMEDIA SERVLET REQUEST ========");
        System.out.println("Media Type: " + type);
        System.out.println("Request Type: POST /media");
        System.out.println("Timestamp: " + new java.util.Date());
        System.out.println("===========================================");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Media Output</h2>");

        if ("image".equals(type)) {
            out.println("<img src='Resources/heat blast.png' width='300' alt='Selected image' />");
        }
        else if ("audio".equals(type)) {
            out.println("<audio controls style='width: 300px;'>");
            out.println("<source src='Resources/audio.mpeg' type='audio/mpeg'>");
            out.println("Your browser does not support audio playback.");
            out.println("</audio>");
        }
        else if ("video".equals(type)) {
            out.println("<video controls width='300'>");
            out.println("<source src='Resources/video.mp4' type='video/mp4'>");
            out.println("Your browser does not support video playback.");
            out.println("</video>");
        }
        else {
            out.println("<p>Please choose a valid media type.</p>");
        }

        out.println("<br><br><a href='index.html'>Back</a>");
        out.println("</body></html>");
    }
}
