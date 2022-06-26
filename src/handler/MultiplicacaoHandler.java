package src.handler;

import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MultiplicacaoHandler implements HttpHandler{
    public static final String PATH = "/multi";

    @Override
    public void handle(HttpExchange conn) throws IOException {
        try{
            String [] parameters = conn.getRequestURI().getPath().split("/");

            if(parameters.length > 4){
                throw new IOException("Voce não pode passar mais que 2 parametros");
            } else if (parameters.length < 4) {
                throw new IOException("Voce não pode passar menos que 2 parametros");
            }

            byte[] response = multiplicar(parameters[2], parameters[3]);

            try {
                response(HTTP_OK, response, conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e){
            response(HTTP_BAD_REQUEST, "Formato de parametro invalido".getBytes(), conn);
        } catch(IOException e){
            response(HTTP_BAD_REQUEST, e.getMessage().getBytes(), conn);
        } finally {
            conn.close();
        }
    }

    byte[] multiplicar(String parameter1, String parameter2){
        double num1 = Double.parseDouble(parameter1);
        double num2 = Double.parseDouble(parameter2);

        double result = num1 * num2;

        return Double.toString(result).getBytes();
    }

    void response(int HTTP_CODE, byte[] response, HttpExchange conn) throws IOException{

        conn.sendResponseHeaders(HTTP_CODE, response.length);

        Headers headers = conn.getResponseHeaders();
        headers.add("Content-Type", "text/html; charset=iso-9881");

        try(OutputStream out = conn.getResponseBody()) {
            out.write(response);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
