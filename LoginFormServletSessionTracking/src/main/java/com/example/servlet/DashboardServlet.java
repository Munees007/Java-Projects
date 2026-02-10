package com.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("index.html");
            return;
        }

        String user = session.getAttribute("user").toString();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html><html><head>");
        out.println("<title>Dashboard</title>");
        out.println("<script src='https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4'></script>");
        out.println("</head>");

        out.println("<body class='min-h-screen flex items-center justify-center bg-gray-100'>");
        out.println("<div class='bg-white p-8 rounded-xl shadow-lg w-full max-w-sm text-center'>");

        out.println("<h1 class='text-2xl font-bold text-indigo-600 mb-4'>Dashboard</h1>");
        out.println("<p class='mb-4'>Welcome <b>" + user + "</b></p>");

        out.println("<form action='logout' method='post'>");
        out.println("<button class='bg-red-600 text-white px-6 py-2 rounded-lg'>Logout</button>");
        out.println("</form>");

        out.println("</div>");
        out.println("<script>");

        out.println("let timeLeft = 5;");
        out.println("let timer;");

        out.println("const timerEl = document.createElement('p');");
        out.println("timerEl.className = 'text-red-600 font-semibold mb-4';");
        out.println("timerEl.id = 'timer';");
        out.println("timerEl.innerText = 'Auto logout in ' + timeLeft + ' seconds';");
        out.println("document.querySelector('div').insertBefore(timerEl, document.querySelector('form'));");

        out.println("function startTimer() {");
        out.println("  clearInterval(timer);");
        out.println("  timeLeft = 5;");
        out.println("  timerEl.innerText = 'Auto logout in ' + timeLeft + ' seconds';");

        out.println("  timer = setInterval(() => {");
        out.println("    timeLeft--;");

        out.println("    if (timeLeft <= 0) {");
        out.println("      clearInterval(timer);");
        out.println("      fetch('logout', { method: 'POST' })");
        out.println("        .then(() => window.location.href = 'index.html');");
        out.println("    } else {");
        out.println("      timerEl.innerText = 'Auto logout in ' + timeLeft + ' seconds';");
        out.println("    }");
        out.println("  }, 1000);");
        out.println("}");

        out.println("window.onload = startTimer;");
        out.println("document.onmousemove = startTimer;");
        out.println("document.onkeypress = startTimer;");
        out.println("document.onclick = startTimer;");

        out.println("</script>");


        out.println("</body></html>");


        out.println("</div></body></html>");
    }
}
