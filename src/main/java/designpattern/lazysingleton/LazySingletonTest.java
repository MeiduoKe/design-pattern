package designpattern.lazysingleton;

/**
 * @ClassName LazySingletonTest
 * @Description 设计模式：懒汉模式
 * @Author Meiduo Ke
 * @Date 2023/2/2 16:08
 * @Version 1.0
 */
public class LazySingletonTest {

    public static void main(String[] args) {
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

class LazySingleton {
    // volatile 禁止指令重排
    // volatile可以保证线程可见性且提供了一定的有序性，但是无法保证原子性。在JVM底层volatile是采用“内存屏障”来实现的。观察加入volatile关键字和没有加入volatile关键字时所生成的汇编代码发现，加入volatile关键字时，会多出一个lock前缀指令，lock前缀指令实际上相当于一个内存屏障（也成内存栅栏），内存屏障会提供3个功能：
    // （1）它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面；即在执行到内存屏障这句指令时，在它前面的操作已经全部完成；
    // （2）它会强制将对缓存的修改操作立即写入主存；
    // （3）如果是写操作，它会导致其他CPU中对应的缓存行无效

    private volatile static LazySingleton instance;

    private LazySingleton() {
    }

// 该模式不够高效
//    public static synchronized LazySingleton getInstance() {
//        if (Objects.isNull(instance)) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    // 在第一次创建的时候加锁
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    // 分配内存b. ctorInstanc(memory)
                    // 初始化对象c. instance = memory
                    // 设置instance指向刚分配的地址
                    // 上面的代码在编译运行时，可能会出现重排序从a-b-c排序为a-c-b
                    // 在多线程的情况下会出现以下问题。当线程A在执行第5行代码时，B线程进来执行到第2行代码
                    // 假设此时A执行的过程中发生了指令重排序，即先执行了a和c，没有执行b。那么由于A线程执行了c导致instance指向了一段地址，
                    // 所以B线程判断instance不为null，会直接跳到第6行并返回一个未初始化的对象
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
