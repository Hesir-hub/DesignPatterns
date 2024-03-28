package com.hxq.designpatterns.singleton;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: Singleton
 * Description: 单利模式    常见：
 *
 * @Author 何西琦
 * @Create 2024/03/21 21:45
 * @Version 1.0
 */
public class SingletonTest {

    public static void main(String[] args) {
        SingletonTest singletonTest = new SingletonTest();
        WeakReference<SingletonTest> weak = new WeakReference<>(singletonTest);
        System.out.println(weak.get());
        System.gc();
        System.out.println(weak.get());
    }
}

/**
 * 饿汉式
 */
class Singleton1 {
    private static Singleton1 singleton = new Singleton1();
    private Singleton1() {}

    public static Singleton1 getSingleton() {
        return singleton;
    }

}

/**
 * 懒汉式
 */
class Singleton2 {
    private static Singleton2 singleton = null;
    private Singleton2() {}

    public synchronized static Singleton2 getSingleton() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}

/**
 * 双检查锁方式
 */
class Singleton3 {

    // volatile 是为了禁止指令重排序
    // new Singleton(); 分三步，1. 分配内存。 2. 初始化 3. 引用指向该地址
    private volatile static Singleton3 singleton = null;
    private Singleton3() {}

    public static Singleton3 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}

/**
 * 枚举
 */
enum Singleton4 {
    singleton
}

