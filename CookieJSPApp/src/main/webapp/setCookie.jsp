<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <% String user=request.getParameter("user"); if (user !=null) { Cookie c=new Cookie("username", user);
        c.setMaxAge(60 * 60 * 24); // 24 hours response.addCookie(c); out.println("<h3>Cookie Set for " + user + "</h3>
        ");
        }
        %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Set Cookie</title>
        </head>

        <body>
            <form action="setCookie.jsp" method="POST">
                Enter Name to store in cookie: <input type="text" name="user">
                <input type="submit" value="Set Cookie">
            </form>
            <br>
            <a href="readCookie.jsp">Read Cookie</a>
        </body>

        </html>