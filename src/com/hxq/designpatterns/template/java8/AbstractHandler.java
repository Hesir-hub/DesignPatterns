package com.hxq.designpatterns.template.java8;

import java.math.BigDecimal;
import java.util.function.Consumer;

/**
 * ClassName: AbstractHandler
 * Description: java8模板方法模式
 *
 * @Author 何西琦
 * @Create 2024/04/08 13:50
 * @Version 1.0
 */
public abstract class AbstractHandler {

    /**
     * 模板方法
     */
    protected void execute(Consumer<Integer> consumer) {
        method1();
        consumer.accept(null);
        mothod3();
    }

    private void mothod3() {
        System.out.println("method3.......");
    }


    private void method1() {
        System.out.println("method1.......");
    }

}
