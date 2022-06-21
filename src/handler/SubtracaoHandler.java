package src.handler;

import static java.net.HttpURLConnection.HTTP_OK;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SubtracaoHandler implements HttpHandler {

    public static final String PATH = "/sub";

    @Override
    public void handle(HttpExchange conn) throws IOException {

        String [] partes = conn.getRequestURI().getPath().split("/");
        byte[] result = subtrair (partes[2], partes[3]);
        
        try {
            conn.sendResponseHeaders(HTTP_OK, result.length);

            Headers headers = conn.getResponseHeaders();
            headers.add("Content-Type", "text/html; charset=UTF-8");

            try (OutputStream out = conn.getResponseBody()) {
                out.write(result);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }            
    }

    byte[] subtrair(String parametro1, String parametro2) {
        double num1 = Double.parseDouble(parametro1);
        double num2 = Double.parseDouble(parametro2);

        double resultado = num1 - num2;

        return Double.toString(resultado).getBytes();
    }

}