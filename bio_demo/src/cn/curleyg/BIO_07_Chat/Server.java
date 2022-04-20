package cn.curleyg.BIO_07_Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 14:10 <br>
 * @Author: Wang
 */

/* 目标：BIO模式下的端口转发思想-服务端实现
 * 服务端实现需求：
 * 1.注册端口
 * 2.接收客户端的socket连接，交给一个独立的线程来处理
 * 3.把当前连接的客户端socket存入到一个所谓的在线socket集合中保存
 * 4.接收客户端的消息，然后推动给当前所有的在线socket接收
 */
public class Server {
    public  static List<Socket> allSocketOnLine=new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            while (true){
                 Socket socket = ss.accept();
                 //把登录的客户端Socket放在一个在线集合当中
                allSocketOnLine.add(socket);
                //为当前socket分配独立的线程处理
                new ServerThreadReader(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
