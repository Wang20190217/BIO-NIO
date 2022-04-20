package cn.curleyg.BIO_07_Chat;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

/**
 * 城南花已开<br>
 *
 * @Description: 服务端线程类<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 13:00 <br>
 * @Author: Wang
 */
public class ServerThreadReader extends Thread {

    private Socket socket;

    public ServerThreadReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //1.从socket中去获取客户端发送的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = br.readLine()) != null) {
                //2.接收到的信息推送到所有的在线Socket集合，
                //通过一个方法进行实现
                    sendMsgToAllClient(msg, socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("当前有人下线了！");
            //从在线socket集合中移除本socket
            Server.allSocketOnLine.remove(socket);
        }
    }

    /* 把当前客户端发送来的消息推送给全部在线的socket*/
    private void sendMsgToAllClient(String msg, Socket socket) throws Exception {
        for (Socket sk : Server.allSocketOnLine) {
            //只发送给除自己以外的其他客户端
            if (socket != sk) {
                PrintStream ps = new PrintStream(sk.getOutputStream());
                ps.println(msg);
                ps.flush();
            }
        }
    }
}

