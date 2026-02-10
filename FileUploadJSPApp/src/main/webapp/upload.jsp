<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>File Upload</title>
    </head>

    <body>
        <h2>Upload File</h2>
        <form action="upload" method="POST" enctype="multipart/form-data">
            Select File: <input type="file" name="file"><br><br>
            <input type="submit" value="Upload">
        </form>
    </body>

    </html>