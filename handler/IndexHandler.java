package handler;

import static java.net.HttpURLConnection.HTTP_OK;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class IndexHandler implements HttpHandler {
    public static final String PATH = "/";

    @Override
    public void handle(HttpExchange conn) throws IOException {

        byte[] msg = Files.readAllBytes(Path.of("html/index.html"));

        try {
            conn.sendResponseHeaders(HTTP_OK, msg.length);

            Headers headers = conn.getResponseHeaders();
            headers.add("Content-Type", "text/html; charset=iso-9881");
            
            try (OutputStream out = conn.getResponseBody()) {
                out.write(msg);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
