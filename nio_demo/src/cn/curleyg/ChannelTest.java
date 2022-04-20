package cn.curleyg;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 城南花已开<br>
 *
 * @Description: 本地文件写数据<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 16:12 <br>
 * @Author: Wang
 */
public class ChannelTest {
    public static void main(String[] args) {

        try {
            //1.字节输出流通向目标文件
            FileOutputStream fos = new FileOutputStream("data01_txt");
            //2.得到字节输出流对应的通道Channel
            FileChannel channel = fos.getChannel();
            //3.分配缓存区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("hello，黑马java程序员！123".getBytes());
            //4.把缓存区切换为写模式
            buffer.flip();
            channel.write(buffer);
            channel.close();
            System.out.println("写数据到文件中！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
