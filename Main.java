import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import handler.*;

import com.sun.net.httpserver.HttpServer;

public class Main{
    public static final int BACKLOG = 200;
    public static void main(String[] args) throws IOException {
        InetSocketAddress bindAddr = new InetSocketAddress(8080);
        HttpServer server = HttpServer.create(bindAddr, BACKLOG);
        server.setExecutor(Executors.newSingleThreadExecutor());

        server.createContext(IndexHandler.PATH, new IndexHandler());

        server.start();
        System.out.printf("Servidor rodando na porta %s\n", server.getAddress().getPort());
    }
}