<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Registration Details</title>
    </head>

    <body>
        <h2>Registered Details</h2>
        <p>Name: <%= request.getParameter("fullname") %>
        </p>
        <p>Email: <%= request.getParameter("email") %>
        </p>
        <p>Gender: <%= request.getParameter("gender") %>
        </p>
        <p>Course: <%= request.getParameter("course") %>
        </p>
        <a href="register.jsp">Back</a>
    </body>

    </html>