package cn.curleyg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 城南花已开<br>
 *
 * @Description: 使用Buffer完成文件复制<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 16:20 <br>
 * @Author: Wang
 */
public class ChannelTest3 {
    public static void main(String[] args)throws Exception {
        //源文件
        File srcFile = new File("C:\\Users\\Lenovo\\Desktop\\1.jpg");
        File destFile = new File("C:\\Users\\Lenovo\\Desktop\\server\\1_copy.jpg");
        //得到一个字节输出流、字节输入流
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);
        //得到文件通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        //分配缓存区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            //必须先清空缓存区然后再写入数据到缓存区
            buffer.clear();
            //开始读取一次数据
            int flag = fisChannel.read(buffer);
            if (flag == -1) {
                break;
            }
            //已经读取了数据，把缓存区的模式切换为可读模式
            buffer.flip();
            //把数据写出到
            fosChannel.write(buffer);
        } fisChannel.close();
        ;
        fosChannel.close();
        System.out.println("复制完成");
    }
}
