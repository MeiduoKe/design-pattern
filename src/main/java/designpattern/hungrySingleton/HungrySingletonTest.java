package designpattern.hungrySingleton;

/**
 * @ClassName HungrySingletonTest
 * @Description 恶汉模式
 * @Author Meiduo Ke
 * @Date 2023/2/2 17:31
 * @Version 1.0
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        System.out.println(hungrySingleton1 == hungrySingleton);

    }
}


class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    // 私有化构造器
    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}