package cn.curleyg.BIO_05;

import java.util.concurrent.*;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/4/20 13:16 <br>
 * @Author: Wang
 */
public class HandlerSocketServerPool {
    //1. 创建一个线程池的成员变量用于存储一个线程池对象
    private ExecutorService executorService;
    /*
     * 2.创建这个类的的对象的时候就需要初始化线程池对象
     *     public ThreadPoolExecutor(int corePoolSize,   核心线程数
                              int maximumPoolSize,       最大线程数
                              long keepAliveTime,        存活时间
                              TimeUnit unit,             时间单位
                              BlockingQueue<Runnable> workQueue,   等待队列
                              ThreadFactory threadFactory,         线程创建工厂
                              RejectedExecutionHandler handler)    拒绝策略
     */
    public HandlerSocketServerPool(int maxThreadNum, int queueSize){
        executorService=new ThreadPoolExecutor(3,maxThreadNum,120,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));

    }
    /*
     *  3.提供一个方法来提交给线程池的任务队列来暂存，等着线程来处理
     */
    public void execute(Runnable target){
        executorService.execute(target);
    }
}
