package com.hxq.designpatterns.proxy.staticproxy;

/**
 * ClassName: StaticProxy
 * Description: 静态代理
 *
 * @Author 何西琦
 * @Create 2024/03/28 18:43
 * @Version 1.0
 */
public class StaticProxy {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.sendMessage("Hello");
    }
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
 * 代理类
 */
class SmsProxy implements SmsService {

    private final SmsService smsService;
    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }
    @Override
    public String sendMessage(String message) {
        System.out.println("before增强");
        smsService.sendMessage(message);
        System.out.println("after增强");
        return "ok";
    }
}


