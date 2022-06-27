package src;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import src.handler.*;

import com.sun.net.httpserver.HttpServer;

public class Main{
    public static final int BACKLOG = 200;
    public static void main(String[] args) throws IOException {
        InetSocketAddress bindAddr = new InetSocketAddress(8080);
        HttpServer server = HttpServer.create(bindAddr, BACKLOG);
        server.setExecutor(Executors.newSingleThreadExecutor());

        server.createContext(IndexHandler.PATH, new IndexHandler());
        server.createContext(SomaHandler.PATH, new SomaHandler());
        server.createContext(SubtracaoHandler.PATH, new SubtracaoHandler());
        server.createContext(MultiplicacaoHandler.PATH, new MultiplicacaoHandler());

        server.start();
        System.out.printf("Servidor rodando em localhost:%s\n", server.getAddress().getPort());
    }
}