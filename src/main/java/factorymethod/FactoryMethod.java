package factorymethod;

/**
 * @Description: 一、工厂方法模式定义
 * 工厂方法模式又称为工厂模式，也叫虚拟构造器模式或者多态工厂模式，它属于类创建型模式。在工厂方法模式中，工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象，
 * 这样做的目的是将产品类的实例化操作延迟到工厂子类中完成，即通过工厂子类来确定究竟应该实例化哪一个具体产品类。
 * 二、 工厂方法的模式结构
 * （1） 抽象工厂(Factory)角色：是工厂方法模式的核心，与应用程序无关。任何在模式中创建的对象的工厂类必须实现这个接口。
 * （2）具体工厂(ConcreteCreator)角色：这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建产品对象。
 * （3）抽象产品(Product)角色：工厂方法模式所创建的对象的超类型，也就是产品对象的共同父类或共同拥有的接口。
 * （4）具体产品(ConcreteProduct)角色：这个角色实现了抽象产品角色所定义的接口。某具体产品有专门的具体工厂创建，它们之间往往一一对应。
 * 四、工厂方法的适用环境
 * （1）一个类不知道它所需要的对象的类：在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体的产品对象由具体工厂类创建；客户端需要知道创建具体产品的工厂类。
 * （2）一个类通过其子类来指定创建哪个对象：在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，从而使得系统更容易扩展。
 * 五、工厂方法的优缺点
 * 1.优点
 * （1）在工厂方法模式中，工厂方法用来创建客户所需要的产品，同时还向客户隐藏了哪种具体产品类将被实例化这一细节，用户只需要关心所需产品对应的工厂，无须关心创建细节，甚至无须知道具体产品类的类名。
 * （2）基于工厂角色和产品角色的多态性设计是工厂方法模式的关键。它能够使工厂可以自主确定创建何种产品对象，而如何创建这个对象的细节则完全封装在具体工厂内部。工厂方法模式之所以又被称为多态工厂模式，是因为所有的具体工厂类都具有同一抽象父类。
 * （3）使用工厂方法模式的另一个优点是在系统中加入新产品时，无须修改抽象工厂和抽象产品提供的接口，无须修改客户端，也无须修改其他的具体工厂和具体产品，而只要添加一个具体工厂和具体产品就可以了。这样，系统的可扩展性也就变得非常好，完全符合“开闭原则”。
 * 2.缺点：
 * （1）在添加新产品时，需要编写新的具体产品类，而且还要提供与之对应的具体工厂类，系统中类的个数将成对增加，在一定程度上增加了系统的复杂度，有更多的类需要编译和运行，会给系统带来一些额外的开销。
 * （2）由于考虑到系统的可扩展性，需要引入抽象层，在客户端代码中均使用抽象层进行定义，增加了系统的抽象性和理解难度。
 * 六、工厂方法的总结
 * 工厂方法模式是简单工厂模式的进一步抽象和推广。工厂方法模式不但保持了简单工厂模式的优点，而且克服了它的缺点。在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。
 * 这个核心类仅仅负责给出具体工厂必须实现的接口，而不负责产品类被实例化这种细节，这使得工厂方法模式可以允许系统在不修改工厂角色的情况下引进新产品。
 * @Author Meiduo Ke
 * @Date 2023/2/2 19:14
 * @Version 1.0
 */
public class FactoryMethod {
    public static void main(String[] args) {

        Factory factory1 = new FactoryA();
        Product product1 = factory1.factoryMethod();
        product1.show();

        Factory factory2 = new FactoryB();
        Product product2 = factory2.factoryMethod();
        product2.show();
    }
}


abstract class Product {
    public abstract void show();
}

class ProductA extends Product {
    public void show() {
        System.out.println("生产了A产品");
    }
}

class ProductB extends Product {
    public void show() {
        System.out.println("生产了B产品");
    }
}

interface Factory {
    Product factoryMethod();
}

class FactoryA implements Factory {
    @Override
    public Product factoryMethod() {
        return new ProductA();
    }
}

class FactoryB implements Factory {
    @Override
    public Product factoryMethod() {
        return new ProductB();
    }
}
