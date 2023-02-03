package abstractfactory;

/**
 * @ClassName AbstractFactoryPattern
 * @Description 抽象工厂模式
 * 2.介绍
 * 2.1.定义
 * 抽象工厂（AbstractFactory）模式的定义：是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 * 2.2.特点
 * 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
 * 使用抽象工厂模式一般要满足以下条件。
 * 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 * 系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 * 2.3.结构与模式
 * 抽象工厂模式同工厂方法模式一样，也是由抽象工厂、具体工厂、抽象产品和具体产品等 4 个要素构成，但抽象工厂中方法个数不同，抽象产品的个数也不同。
 * 抽象工厂模式的主要角色如下：
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
 * 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系。
 * 3.应用场景
 * 3.1.优缺点
 * 3.1.1.优点
 * 降低耦合
 * 抽象工厂模式将具体产品的创建延迟到具体工厂的子类中，这样将对象的创建封装起来，可以减少客户端与具体产品类之间的依赖，从而使系统耦合度低，这样更有利于后期的维护和扩展；
 * 更符合开——闭原则
 * 新增一种产品类时，只需要增加相应的具体产品类和相应的工厂子类即可
 * 符合单一职责原则
 * 每个具体工厂类只负责创建对应的产品
 * 不使用静态工厂方法，可以形成基于继承的等级结构。
 * 3.1.2.缺点
 * 抽象工厂模式很难支持新种类产品的变化。
 * 这是因为抽象工厂接口中已经确定了可以被创建的产品集合，如果需要添加新产品，此时就必须去修改抽象工厂的接口，这样就涉及到抽象工厂类的以及所有子类的改变，这样也就违背了“开发——封闭”原则。
 * 对于新的产品族符合开-闭原则；对于新的产品种类不符合开-闭原则，这一特性称为开-闭原则的倾斜性。
 * 3.2.应用场景
 * 抽象工厂模式最早的应用是用于创建属于不同操作系统的视窗构件。如 Java 的 AWT 中的 Button 和 Text 等构件在 Windows 和 UNIX 中的本地实现是不同的。
 * 抽象工厂模式通常适用于以下场景：
 * 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。
 * 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。
 * 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。
 * @Author Meiduo Ke
 * @Date 2023/2/3 10:29
 * @Version 1.0
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Factory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.makeProductA();
        ProductB productB1 = factory1.makeProductB();
        productA1.showA();
        productB1.showB();

        Factory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.makeProductA();
        ProductB productB2 = factory2.makeProductB();
        productA2.showA();
        productB2.showB();

//        this is ConcreteProductA1
//        this is ConcreteProductB1
//        this is ConcreteProductA2
//        this is ConcreteProductB2
    }
}

/***
 * @ClassName ProductA
 * @Description 产品A抽象接口
 * @Author Meiduo Ke
 * @Date 10:47 10:47
 */
interface ProductA {
    void showA();
}

/***
 * @ClassName ProductB
 * @Description 产品B抽象接口
 * @Author Meiduo Ke
 * @Date 10:47 10:47
 */
interface ProductB {
    void showB();
}

/***
 * @ClassName ConcreteProductA1
 * @Description 具体产品A1
 * @Author Meiduo Ke
 * @Date 10:47 10:47
 */
class ConcreteProductA1 implements ProductA {
    @Override
    public void showA() {
        System.out.println("this is ConcreteProductA1");
    }
}

/***
 * @ClassName ConcreteProductA2
 * @Description 具体产品A2
 * @Author Meiduo Ke
 * @Date 10:47 10:47
 */
class ConcreteProductA2 implements ProductA {
    @Override
    public void showA() {
        System.out.println("this is ConcreteProductA2");
    }
}

/***
 * @ClassName ConcreteProductB1
 * @Description 具体产品B1
 * @Author Meiduo Ke
 * @Date 10:47 10:47
 */
class ConcreteProductB1 implements ProductB {
    @Override
    public void showB() {
        System.out.println("this is ConcreteProductB1");
    }
}

/***
 * @ClassName ConcreteProductB2
 * @Description 具体产品B2
 * @Author Meiduo Ke
 * @Date 10:47 10:47
 */
class ConcreteProductB2 implements ProductB {
    @Override
    public void showB() {
        System.out.println("this is ConcreteProductB2");
    }
}

/***
 * @ClassName Factory
 * @Description 抽象工厂
 * @Author Meiduo Ke
 * @Date 10:47 10:47
 */
interface Factory {
    ProductA makeProductA();

    ProductB makeProductB();
}

/***
 * @ClassName Factory
 * @Description 具体工厂1
 * @Author Meiduo Ke
 * @Date 10:47 10:47
 */
class ConcreteFactory1 implements Factory {

    @Override
    public ProductA makeProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB makeProductB() {
        return new ConcreteProductB1();
    }
}

/***
 * @ClassName Factory
 * @Description 具体工厂2
 * @Author Meiduo Ke
 * @Date 10:47 10:47
 */
class ConcreteFactory2 implements Factory {

    @Override
    public ProductA makeProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB makeProductB() {
        return new ConcreteProductB2();
    }
}

