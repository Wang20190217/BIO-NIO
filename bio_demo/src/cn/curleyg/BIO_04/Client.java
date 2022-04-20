package cn.curleyg.BIO_04;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 城南花已开<br>
 * 我们启动了多个客户端实例发现服务端只接受最开始的客户端的消息，因为当前服务端是单线程。
 * @Description: 多客户端发送<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 12:20 <br>
 * @Author: Wang
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.创建Socket对象请求服务端的连接
            Socket socket = new Socket("127.0.0.1",9999);
            //2.从Socket对象中获取一个字节输出流
            OutputStream os= socket.getOutputStream();
            // 3.把字节输出流包装成一个打印流
            PrintStream ps = new PrintStream(os);
            Scanner sc=new Scanner(System.in);
            while(true){
                System.out.println("请输入发送的信息：");
                String msg=sc.nextLine();
                ps.println(msg);
                ps.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
