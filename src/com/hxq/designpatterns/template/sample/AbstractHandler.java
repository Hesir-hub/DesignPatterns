package com.hxq.designpatterns.template.sample;

/**
 * ClassName: AbstractHandler
 * Description: 模板方法模式，常见：AQS
 *
 * @Author 何西琦
 * @Create 2024/04/08 13:50
 * @Version 1.0
 */
public abstract class AbstractHandler {

    /**
     * 模板方法
     */
    public final void execute() {
        method1();
        method2();
        mothod3();
    }

    private void mothod3() {
        System.out.println("method3.......");
    }

    public abstract void method2();

    private void method1() {
        System.out.println("method1.......");
    }

}
