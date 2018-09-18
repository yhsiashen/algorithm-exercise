package com.chinalife.springmvc.service;

import com.chinalife.springmvc.entity.Seckill;
import org.apache.commons.net.io.SocketOutputStream;

import java.io.*;
import java.net.Socket;

/**
 * Created by chinalife on 2017/9/26.
 */
public class Test {

      public static void main(String[] args) throws IOException, ClassNotFoundException {
          InputStream in = new FileInputStream("D:\\Users\\chinalife\\Desktop\\javaio\\out.txt");
//          byte[] bytes = new byte[1024*10];
//          in.read(bytes);
//          for(int i =0;i<bytes.length;i++){
//              System.out.println(bytes[i]);
//          }
//          OutputStream out = new FileOutputStream("D:\\Users\\chinalife\\Desktop\\javaio\\out.txt");
          Seckill seckill = new Seckill();
          seckill.setName("yuhang");
          seckill.setSeckillId(18100516);

//          ObjectOutputStream oot = new ObjectOutputStream(out);
//          oot.writeObject(seckill);

//          ObjectInputStream iit = new ObjectInputStream(in);
//         Seckill seckill11= (Seckill) iit.readObject();
//         System.out.println(seckill11.toString());

          FileOutputStream fout = new FileOutputStream("D:\\Users\\chinalife\\Desktop\\javaio\\ffout.txt");
          byte[] bytes = new byte[1024*10];
          fout.write(seckill.toString().getBytes());

//
//         fout.write(bytes);
//         Socket socket = new Socket();
//          SocketOutputStream sout = new SocketOutputStream(socket,fout);


      }
}
