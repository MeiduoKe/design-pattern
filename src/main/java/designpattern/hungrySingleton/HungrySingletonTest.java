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

/***
 * 恶汉模式：类加载的 初始化阶段就完成了 实例化的初始化。本质上就是借助于 jvm 类加载机制，保证实例的唯一性
 * 类加载过程：
 * 1. 加载二进制数据到内存中，生成对应的class数据结构
 * 2. 连接： a、验证 b、准备（给类的静态成员变量赋默认值） c、解析
 * 3. 初始化：给类的静态变量赋初始值
 * 只有真正使用对应的类时，才会触发初始化，如（当前类是main函数的所在类，直接进行new操作，访问静态属性，访问静态方法，
 * 用反射访问类。初始化一个类的子类）
 */

class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    // 私有化构造器
    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}