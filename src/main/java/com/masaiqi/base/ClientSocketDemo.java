package com.masaiqi.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.lang.String;

/**
 * socket客户端模拟。
 * <p>
 * 最基本示例
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

        socket.close();
        out.close();
        inFromConsole.close();

    }


}
