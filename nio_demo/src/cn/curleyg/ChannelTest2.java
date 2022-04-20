package cn.curleyg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 城南花已开<br>
 *
 * @Description: 本地文件读数据<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 16:16 <br>
 * @Author: Wang
 */
public class ChannelTest2 {
    public static void main(String[] args) {

        try {
            //1.字节输出流通向目标文件
            FileInputStream is = new FileInputStream("data01_txt");
            //2.得到字节输出流对应的通道Channel
            FileChannel channel = is.getChannel();
            //3.分配缓存区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //4.读取数据到缓存区
            channel.read(buffer);
            buffer.flip();//归位
            // 5.读取出缓存区中的数据并输出即可
            String rs = new String(buffer.array(),0,buffer.remaining());
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

