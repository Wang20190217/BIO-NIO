package cn.curleyg.BIO_05;

import cn.curleyg.BIO_04.ServerThreadReader;

import java.io.IOException;
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
            //线程池初始化
            HandlerSocketServerPool pool = new HandlerSocketServerPool(6,10);
            while (true){
                Socket socket = ss.accept();
                //3.把socket对象交给线程池来处理
                //把socket封装成任务对象来处理
                Runnable target = new ServerRunnableTarget(socket);
                pool.execute(target);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
