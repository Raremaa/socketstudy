package com.masaiqi.duplex;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * socket双工通信客户端模拟。
 *
 * @author sq.ma
 * @date 2019/12/5 上午12:26
 */
public class ClientSocketDemo {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8829);

        //获取输出流
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        //通过控制台获取数据
        BufferedReader inFromConsole = new BufferedReader(new InputStreamReader(System.in));
        String line = inFromConsole.readLine();

        out.println(new String(line.getBytes(StandardCharsets.UTF_8)));
        out.flush();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len,"UTF-8"));
        }
        System.out.println("get message from server: " + sb);


        inputStream.close();
        out.close();
        inFromConsole.close();
        socket.close();
    }


}
