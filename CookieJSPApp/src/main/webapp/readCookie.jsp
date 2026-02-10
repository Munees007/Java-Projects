<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Read Cookie</title>
    </head>

    <body>
        <h2>Reading Cookies</h2>
        <% Cookie[] cookies=request.getCookies(); boolean found=false; if (cookies !=null) { for (Cookie c : cookies) {
            if (c.getName().equals("username")) { out.println("<p>Found Cookie - Username: " + c.getValue() + "</p>");
            found = true;
            }
            }
            }
            if (!found) {
            out.println("<p>No 'username' cookie found.</p>");
            }
            %>
            <a href="setCookie.jsp">Back</a>
    </body>

    </html>