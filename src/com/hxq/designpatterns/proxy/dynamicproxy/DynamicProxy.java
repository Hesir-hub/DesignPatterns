package com.hxq.designpatterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: DynamicProxy
 * Description: 动态代理， 常见：Spring AOP、RPC框架
 *
 * @Author 何西琦
 * @Create 2024/03/28 18:52
 * @Version 1.0
 */
public class DynamicProxy {

}

/**
 * 代理接口
 */
interface SmsService {
    String sendMessage(String message);
}

/**
 * 实现类
 */
class SmsServiceImpl implements SmsService {
    @Override
    public String sendMessage(String message) {
        System.out.println("Send message: " + message);
        return "ok";
    }
}
/**
 * JDK动态代理-代理对象
 */
class JDKSmsProxy implements InvocationHandler {
    // 代理真实对象
    private final Object target;
    public JDKSmsProxy(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before 增强" + method.getName());
        Object res = method.invoke(target, args);
        System.out.println("after 增强" + method.getName());
        return res;
    }
}
/**
 * JDK动态代理-代理对象的工厂类
 */
class JDKSmsProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),// 目标类加载器
                target.getClass().getInterfaces(), // 代理需要实现的接口
                new JDKSmsProxy(target));   // 代理对象
    }
}
