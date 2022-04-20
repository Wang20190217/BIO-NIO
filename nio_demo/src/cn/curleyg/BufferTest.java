package cn.curleyg;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * 城南花已开<br>
 *
 * @Description: 缓冲区测试类<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 15:30 <br>
 * @Author: Wang
 */
public class BufferTest {

    /**
     Buffer clear(）清空缓冲区并返回对缓冲区的引用
     Buffer flip(）为将缓冲区的界限设置为当前位置，并将当前位置重置为0
     int capacity(）返回Buffer的capacity大小
     boolean hasRemaining(）判断缓冲区中是否还有元素
     int limit(）返回Buffer的界限（limit）的位置
     Buffer limit(int n）将设置缓冲区界限为n，并返回一个具有新limit的缓冲区对象
     Buffer mark(）对缓冲区设置标记
     int position(）返回缓冲区的当前位置position
     Buffer position(int n）将设置缓冲区的当前位置为n，并返回修改后的Buffer对象
     int remaining()返回position和limit之间的元素个数
     Buffer reset(）将位置position转到以前设置的mark所
    */
    public static void main(String[] args) {
        //1.分配一个缓冲区容量为10
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.position());//返回缓冲区的当前位置position 0
        System.out.println(byteBuffer.limit());//返回Buffer的界限（limit）的位置  10
        System.out.println(byteBuffer.capacity());//返回Buffer的capacity大小  10
        System.out.println("---------------------------------------------------------");

        //往缓冲区添加数据
        String name="wangshuai";
        byteBuffer.put(name.getBytes());
        System.out.println(byteBuffer.position());//返回缓冲区的当前位置position  9
        System.out.println(byteBuffer.limit());//返回Buffer的界限（limit）的位置  10
        System.out.println(byteBuffer.capacity());//返回Buffer的capacity大小  10
        System.out.println("---------------------------------------------------------");
        // Buffer flip(）为将缓冲区的界限设置为当前位置，并将当前位置重置为0   可读模式
        byteBuffer.flip();
        System.out.println(byteBuffer.position());//返回缓冲区的当前位置position  0
        System.out.println(byteBuffer.limit());//返回Buffer的界限（limit）的位置  9
        System.out.println(byteBuffer.capacity());//返回Buffer的capacity大小  10

        //4.get 数据的读取
        char ch=(char)byteBuffer.get();
        System.out.println(ch);
        System.out.println(byteBuffer.position());//返回缓冲区的当前位置position  1
        System.out.println(byteBuffer.limit());//返回Buffer的界限（limit）的位置  6
        System.out.println(byteBuffer.capacity());//返回Buffer的capacity大小  10

    }


}
