package cn.curleyg.BIO_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

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
            //从socket对象中得到一个字节输入流
            InputStream is = socket.getInputStream();
            //使用缓存字符输入流包装字节输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

