package com.hxq.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ObserverPattern
 * Description: 观察者模式   例子：回调函数，事件机制
 *
 * @Author 何西琦
 * @Create 2024/04/01 13:35
 * @Version 1.0
 */
public class ObserverPattern {
}

interface Debit {
    void borrow(Credit credit);
    void notifyCredits();
}
class ZhangSan implements Debit {
    private List<Credit> credits = new ArrayList<Credit>();

    @Override
    public void borrow(Credit credit) {
        credits.add(credit);
    }

    @Override
    public void notifyCredits() {
        for (Credit credit : credits) {
            credit.takeMoney();
        }
    }
}
interface Credit {
    void takeMoney();
}

