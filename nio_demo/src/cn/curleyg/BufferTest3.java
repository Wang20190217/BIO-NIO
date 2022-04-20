package cn.curleyg;

import java.nio.ByteBuffer;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 16:05 <br>
 * @Author: Wang
 */
public class BufferTest3 {
    public static void main(String[] args) {
        //1.创建一个直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());
    }


}
