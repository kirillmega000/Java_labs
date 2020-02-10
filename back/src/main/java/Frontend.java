import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Frontend extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = new HashMap<String, Object>() ;

        String message = request.getParameter("key");

        response.setContentType("text/html;charset=utf-8");

        if (message == null || message.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        pageVariables.put("key", message == null ? "" : message);
        response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
    }
}
