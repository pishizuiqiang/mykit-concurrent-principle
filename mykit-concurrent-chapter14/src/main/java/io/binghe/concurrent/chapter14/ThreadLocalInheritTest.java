package io.binghe.concurrent.chapter14;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试ThreadLocal的继承性
 */
public class ThreadLocalInheritTest {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<String>();

    public static void main(String[] args){
        //在主线程中通过THREAD_LOCAL保存值
        THREAD_LOCAL.set("binghe");

        //在子线程中通过THREAD_LOCAL获取在主线程中保存的值
        new Thread(()->{
            System.out.println("在子线程中获取到的本地变量的值为: " + THREAD_LOCAL.get());
        } ).start();

        //在主线程中通过THREAD_LOCAL获取在主线程中保存的值
        System.out.println("在主线程中获取到的本地变量的值为: " + THREAD_LOCAL.get());
    }
}
