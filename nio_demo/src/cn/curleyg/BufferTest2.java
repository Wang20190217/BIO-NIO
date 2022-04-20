package cn.curleyg;

import java.nio.ByteBuffer;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 15:47 <br>
 * @Author: Wang
 */
public class BufferTest2 {
    public static void main(String[] args) {
        //1.分配一个缓冲区容量为10
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.position());//返回缓冲区的当前位置position 0
        System.out.println(byteBuffer.limit());//返回Buffer的界限（limit）的位置  10
        System.out.println(byteBuffer.capacity());//返回Buffer的capacity大小  10
        System.out.println("---------------------------------------------------------");
        //往缓冲区添加数据
        String name = "wangshuai";
        byteBuffer.put(name.getBytes());
        System.out.println(byteBuffer.position());//返回缓冲区的当前位置position  9
        System.out.println(byteBuffer.limit());//返回Buffer的界限（limit）的位置  10
        System.out.println(byteBuffer.capacity());//返回Buffer的capacity大小  10
        System.out.println("---------------------------------------------------------");
        byteBuffer.clear(); //回到0位置
        System.out.println(byteBuffer.position());//返回缓冲区的当前位置position  0
        System.out.println(byteBuffer.limit());//返回Buffer的界限（limit）的位置  10
        System.out.println(byteBuffer.capacity());//返回Buffer的capacity大小  10
        System.out.println((char)byteBuffer.get());
        System.out.println("---------------------------------------------------------");
        ByteBuffer buf = ByteBuffer.allocate(20);
        String n = "wangdanming";
        buf.put(n.getBytes());
        buf.flip();
        //读取数据
        byte[] b=new byte[2];
        buf.get(b);
        System.out.println(new String(b));
        System.out.println(buf.position());//返回缓冲区的当前位置position  2
        System.out.println(buf.limit());//返回Buffer的界限（limit）的位置  11
        System.out.println(buf.capacity());//返回Buffer的capacity大小  20
        System.out.println("---------------------------------------------------------");
        buf.mark();  //标记这个位置
        byte[] b2=new byte[3];
        buf.get(b2);
        System.out.println(new String(b2));
        System.out.println(buf.position());//返回缓冲区的当前位置position  5
        System.out.println(buf.limit());//返回Buffer的界限（limit）的位置  11
        System.out.println(buf.capacity());//返回Buffer的capacity大小  20
        System.out.println("---------------------------------------------------------");
        buf.reset();   //回到标记位置
        byte[] b3=new byte[4];
        buf.get(b3);
        System.out.println(new String(b3));
        System.out.println(buf.position());//返回缓冲区的当前位置position  6
        System.out.println(buf.limit());//返回Buffer的界限（limit）的位置  11
        System.out.println(buf.capacity());//返回Buffer的capacity大小  20
        System.out.println("---------------------------------------------------------");
        if(buf.hasRemaining()){  //判断是否还有剩余数据
            System.out.println(buf.remaining());  //显示剩余个数 5
        }
        System.out.println(new String(b3));
        System.out.println(buf.position());//返回缓冲区的当前位置position  6
        System.out.println(buf.limit());//返回Buffer的界限（limit）的位置  11
        System.out.println(buf.capacity());//返回Buffer的capacity大小  20
    }
}
