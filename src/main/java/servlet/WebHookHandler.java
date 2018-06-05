package servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "PaperBot",
        urlPatterns = {"/paperbot"}
)


public class WebHookHandler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();

        try {
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

        } finally {
            reader.close();
        }

        System.out.println(sb.toString());
    }
}
