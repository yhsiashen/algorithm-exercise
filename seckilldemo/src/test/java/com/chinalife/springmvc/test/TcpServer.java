package com.chinalife.springmvc.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chinalife on 2017/11/15.
 */
public class TcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss =new ServerSocket(80);
            Socket socket = ss.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = null;
            while ((s=bufferedReader.readLine())!=null){
                System.out.println(s);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("nihao");
            ss.close();
            socket.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
