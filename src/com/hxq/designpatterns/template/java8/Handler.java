package com.hxq.designpatterns.template.java8;

/**
 * ClassName: Handler
 * Description:
 *
 * @Author 何西琦
 * @Create 2024/04/08 14:04
 * @Version 1.0
 */
public class Handler extends AbstractHandler{

    public void handler1(int c) {
        execute(a -> System.out.println("handler1:" + c));
    }

    public void handler2(int c) {
        execute(a -> System.out.println("handler2:" + c));
    }

    public void handler3(int c) {
        execute(a -> System.out.println("handler3:" + c));
    }
}
