<%
    String user = (String) session.getAttribute("user");
    if(user == null){
        response.sendRedirect("index.jsp");
    }
%>

<h2>Welcome <%= user %></h2>
<form action="LogoutServlet" method="post">
    <button>Logout</button>
</form>
