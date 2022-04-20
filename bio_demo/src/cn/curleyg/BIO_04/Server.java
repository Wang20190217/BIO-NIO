package cn.curleyg.BIO_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 城南花已开<br>
 *
 * @Description: 服务器端<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 12:21 <br>
 * @Author: Wang
 */
public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("===服务端启动===");
            //1.定义一个ServerSocket对象进行服务端的端口注册
            ServerSocket ss = new ServerSocket(9999);
            //2. 定义一个死循环不断地去接收Socket请求，监听客户端的Socket连接请求
            while (true){
                Socket socket = ss.accept();
                //3.创建一个独立的线程来处理与这个客户端的socket通信需求
                new ServerThreadReader(socket).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
