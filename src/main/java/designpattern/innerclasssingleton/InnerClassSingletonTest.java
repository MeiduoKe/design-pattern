package designpattern.innerclasssingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName InnerClassSingletonTest
 * @Description 静态内部类方式: 懒加载方式
 * @Author Meiduo Ke
 * @Date 2023/2/2 18:07
 * @Version 1.0
 */
public class InnerClassSingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        new Thread(() -> {
            InnerClassSingleton instance = InnerClassSingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            InnerClassSingleton instance = InnerClassSingleton.getInstance();
            System.out.println(instance);
        }).start();

        // 反射创建对象
        Constructor<InnerClassSingleton> declaredClasses = InnerClassSingleton.class.getDeclaredConstructor();
        declaredClasses.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaredClasses.newInstance();

        InnerClassSingleton instance = InnerClassSingleton.getInstance();

        System.out.println(innerClassSingleton == instance); // false


    }
}

class InnerClassSingleton {
    private static class InnerClassSingletonHolder {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        if (InnerClassSingletonHolder.instance != null) {
            throw new RuntimeException("单利模式不允许反射创建对象");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassSingletonHolder.instance;
    }
}
