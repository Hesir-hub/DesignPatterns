package com.hxq.designpatterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: DynamicProxy
 * Description: 动态代理， 常见：Spring AOP、RPC框架
 * JDK动态代理只能代理实现了接口的类：通过实现目标类的接口进行代理，效率更高
 * CGLIB动态代理可以代理未实现任何接口的类：通过继承目标类进行代理，效率较低  动态代理运行时动态生成字节码文件
 * 静态代理，不灵活，对每个目标类都要创建代理类，新增方法，目标类和代理类都要修改，代理类编译时就成了字节码文件
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
