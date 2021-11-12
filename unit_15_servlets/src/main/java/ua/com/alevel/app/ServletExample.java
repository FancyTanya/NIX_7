package ua.com.alevel.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/hello")
public class ServletExample extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ServletExample.class);
    private  final ConcurrentHashMap<String,String> map = new ConcurrentHashMap();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");

//        Enumeration headers = req.getHeaderNames();
//        while (headers.hasMoreElements()) {
        String ipAddress = req.getRemoteAddr();
        String browserName = req.getHeader("user-agent");
        map.put(ipAddress, browserName);

        responseBody.println("<html>");
        responseBody.println("<h3 align=\"center\">Request from: " + map + "</h3>");
        responseBody.println("<h3 align=\"center\">Current IP : " + "<i>" + ipAddress + "</i>" + "</h3>");
        responseBody.println("</html>");
//        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
