package com.hxq.designpatterns.factory;

/**
 * ClassName: FactoryTest
 * Description: 工厂模式    常见：DateFormat
 *
 * @Author 何西琦
 * @Create 2024/03/23 19:18
 * @Version 1.0
 */
interface Product{}
interface ProductNum{}
class ProductA implements Product {}
class ProductB implements Product {}
class Product1 implements ProductNum {}
class Product2 implements ProductNum {}
public class FactoryTest {
}

/**
 * 简单工程模式   // TODO 违反了开闭原则
 */
class SimpleFactory {
    public static Product createProduct(String name) {
        if ("A".equals(name)) {
            return new ProductA();
        } else if ("B".equals(name)) {
            return new ProductB();
        }
        return null;
    }
}


/**
 * 工厂方法模式   // TODO：每次需要新建工厂
 */
interface ProductFactory {
    public Product createProduct();
}
class ProductAFactory implements  ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
class ProductBFactory implements  ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

/**
 * 抽象工厂模式
 */
interface AbstractProductFactory {
    public Product createProduct();
    public ProductNum createProductNum();
}
class ProductFactoryA1 implements AbstractProductFactory {

    @Override
    public Product createProduct() {
        return new ProductA();
    }

    @Override
    public ProductNum createProductNum() {
        return new Product1();
    }
}
class ProductFactoryB2 implements AbstractProductFactory {

    @Override
    public Product createProduct() {
        return new ProductB();
    }

    @Override
    public ProductNum createProductNum() {
        return new Product2();
    }
}

