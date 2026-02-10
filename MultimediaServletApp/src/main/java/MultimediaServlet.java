import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/multimedia")
public class MultimediaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Multimedia Content</h2>");
        out.println("<p>Displaying an Image:</p>");
        out.println("<img src='https://placehold.co/600x400' alt='Placeholder Image'>");
        out.println("<p>Displaying a Video:</p>");
        out.println("<video width='320' height='240' controls>");
        out.println("<source src='movie.mp4' type='video/mp4'>");
        out.println("Your browser does not support the video tag.");
        out.println("</video>");
        out.println("</body></html>");
    }
}
