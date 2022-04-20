package cn.curleyg.BIO_06_File;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 13:49 <br>
 * @Author: Wang
 */

/* 目标：服务端开发，可以实现接收客户端的任意类型文件，并保存到服务器端磁盘 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            while (true) {
                Socket socket = ss.accept();
                //交给一个独立的线程来处理与这个客户端的文件通信需求
            new ServerThreadReader(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
