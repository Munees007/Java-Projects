import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkPrime")
public class PrimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String numStr = request.getParameter("number");
        if (numStr != null && !numStr.isEmpty()) {
            int num = Integer.parseInt(numStr);
            boolean isPrime = checkPrime(num);
            out.println("<h3>Result: " + num + " is " + (isPrime ? "Prime" : "Not Prime") + "</h3>");
        } else {
            out.println("<h3>Please provide a number!</h3>");
        }
        out.println("<a href='index.html'>Back</a>");
    }

    private boolean checkPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
