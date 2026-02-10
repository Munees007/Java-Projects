<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Registration Form</title>
    </head>

    <body>
        <h2>User Registration</h2>
        <form action="display.jsp" method="POST">
            Full Name: <input type="text" name="fullname"><br>
            Email: <input type="email" name="email"><br>
            Gender:
            <input type="radio" name="gender" value="Male"> Male
            <input type="radio" name="gender" value="Female"> Female<br>
            Course:
            <select name="course">
                <option value="Java">Java</option>
                <option value="Python">Python</option>
                <option value="C++">C++</option>
            </select><br>
            <input type="submit" value="Register">
        </form>
    </body>

    </html>