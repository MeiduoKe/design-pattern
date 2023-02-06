package proxypattern.static_proxy;

/**
 * @ClassName StaticProxy
 * @Description 静态代理
 * @Author Meiduo Ke
 * @Date 2023/2/6 9:53
 * @Version 1.0
 */
public class StaticProxy {
    public static void main(String[] args) {
        Subject subject = new Proxy(new RealSubject());
        subject.request();
    }
}

// Subject接口
interface Subject {
    void request();
}

// 目标对象 RealSubject
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject execute request");
    }
}

// Proxy 代理类
class Proxy implements Subject {
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("before");
        try {
            realSubject.request();
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            System.out.println("after");
        }
    }
}



