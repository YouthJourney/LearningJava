package com.hong.test1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;  //打开服务器
        try {
            serverSocket = new ServerSocket(7070);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(serverSocket==null){
            return;
        }
        System.out.println("服务器打开完成");
        while(true){
            try {
                System.out.println("服务器等待客户端连接");
                Socket socket = serverSocket.accept();  //等待客户端的连接 阻塞
                SocketServerThread socketThread = new SocketServerThread(socket);
                new Thread(socketThread).start();
                System.out.println("服务器处理客户端连接完成");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
