package designpattern.eunmsingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName EnumSingleton
 * @Description 单例模式：枚举方式
 * @Author Meiduo Ke
 * @Date 2023/2/2 18:50
 * @Version 1.0
 */
public enum EnumSingleton {
    ENUM_SINGLETON;

    public static EnumSingleton getInstance() {
        return ENUM_SINGLETON;
    }
}

class EnumSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        EnumSingleton enumSingleton1 = EnumSingleton.getInstance();
        System.out.println(enumSingleton1 == enumSingleton); // ture

        // 判断线程是否安全
        new Thread(() -> {
            EnumSingleton instance = EnumSingleton.getInstance();
            System.out.println(instance); // ENUM_SINGLETON
        }).start();

        new Thread(() -> {
            EnumSingleton instance = EnumSingleton.getInstance();
            System.out.println(instance); // ENUM_SINGLETON
        }).start();

        // 反射攻击
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, Integer.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton enumSingleton2 = declaredConstructor.newInstance("hello", 123);
        System.out.println(enumSingleton2 == enumSingleton); // 运行异常



    }
}
