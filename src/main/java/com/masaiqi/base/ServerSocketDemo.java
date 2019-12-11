package com.masaiqi.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * socket服务端模拟。
 * <p>
 * 最基本示例
 *
 * @author sq.ma
 * @date 2019/12/5 上午12:01
 */
public class ServerSocketDemo {

    public static void main(String[] args) throws IOException {

        //监听端口 ，ip默认是本机
        ServerSocket serverSocket = new ServerSocket(8829);

        //接收客户端的连接(阻塞，需要等待客户端连接进行下一步操作)
        Socket socket = serverSocket.accept();

        //获取输入流
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

        //输出输入流数据
        System.out.println("receive message from client: " + in.readLine());

        socket.close();
        in.close();

    }
}
