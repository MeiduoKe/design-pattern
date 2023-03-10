package builderpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BuilderPattern
 * @Description 建造者模式
 * <p>
 * 2.介绍<p>
 * 2.1.定义<p>
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 * <p>
 * 2.2.解决的问题<p>
 * 在用户不知道对象的建造过程和细节的情况下就可以直接创建复杂的对象。
 * 用户只需要给出指定复杂对象的类型和内容；建造者模式负责按既定规则创建复杂对象（把内部的建造过程和细节隐藏起来)
 * <p>
 * 2.3.结构与模式<p>
 * 建造者模式通常包括下几个角色：
 * <p>
 * Builder（抽象建造者）：给出一个抽象结论，以规范产品对象的各个组成成分的建造。这个接口规定要实现复杂对象的那些部分的创建，并不涉及具体的对象部件的创建。
 * ConcreteBuilder（具体建造者）：实现Builder接口，针对不同的商业逻辑，具体化复杂对象的各部分的创建。在构造过程完成后，提供产品的实例。
 * Director（指导者）：调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建。
 * Product（产品类）：要创建的复杂对象
 * <p>
 * 5.1.优缺点<p>
 * 5.1.1.优点<p>
 * 使用建造者模式可以使客户端不必知道产品内部的组成细节。（封装性）
 * 具体的建造者之间是相互独立的，对系统的扩展非常有利。（扩展性）
 * 由于具体的建造者是独立的，因此可以对建造过程逐步细化，而不对其他模块产生任何影响。
 * 5.1.2.缺点<p>
 * 产品的组成部分必须相同，这限制了其使用范围。
 * 如果产品的内部变化复杂，如果产品内部发生变化，则建造者也要同步修改，后期维护成本较大。
 * 在创建产品之前必须要创建建造者，对性能有一定影响，特别是在数据量较大的情况下。
 * 5.2.3与抽象工厂的区别<p>
 * 在建造者模式里，有个指导者，由指导者来管理建造者，用户是与指导者联系的，指导者联系建造者最后得到产品。
 * 即建造模式可以强制实行一种分步骤进行的构造过程。工厂模式是将对象的全部创建过程封装在工厂类中，由工厂类想客户端提供最终的产品。
 * 而在建造者模式中，建造者类一般只提供产品类中各个组件的建造，而将具体建造过程交付给指导者，由指导者负责将各个组件按照特定的规则组建为产品，
 * 然后将组建好的产品交付给客户端。
 * <p>
 * 5.3.适用场景<p>
 * 需要生产的产品对象有复杂的内部结构。
 * 需要生产的产品对象的属性相互依赖，建造者模式可以强迫生成顺序。
 * 在对象创建过程中会使用到系统中的一些其它对象，这些对象在产品对象的创建过程中不易得到。
 * @Author Meiduo Ke
 * @Date 2023/2/3 11:09
 * @Version 1.0
 */
public class BuilderPattern {
    public static void main(String[] args) {
        ResidenceBuilder rb = new ResidenceBuilder();
        Designer designer1 = new Designer(rb);
        Building building = designer1.build();
        building.show();
        Building highBuilding = designer1.buildHigh();
        highBuilding.show();

        CountingBuilder cb = new CountingBuilder();
        Designer designer2 = new Designer(cb);
        Building count = designer2.build();
        count.show();
        Building highCount = designer2.buildHigh();
        highCount.show();
    }
}

/*
 * 为了容易理解，这次设计一个场景——建设住宅建筑，Builder 为建筑工人抽象，Building 为住宅建筑抽象，Designer 为设计师：
 * 下面的代码为设计师通过建筑工人建设普通住宅建筑和高层住宅建筑的代码
 */

/***
 * @ClassName Building
 * @Description 住宅建筑抽象
 * @Author Meiduo Ke
 * @Date 11:25 11:25
 */
interface Building {
    void addRooms(String room);

    void addFloors(String floor);

    List<String> getRooms();

    List<String> getFloors();

    void show();
}

/***
 * @ClassName ResidenceBuilding
 * @Description 具体住宅建筑
 * @Author Meiduo Ke
 * @Date 11:25 11:25
 */
class ResidenceBuilding implements Building {
    List<String> rooms;
    List<String> floors;

    public ResidenceBuilding() {
        this.rooms = new ArrayList<>();
        this.floors = new ArrayList<>();
    }

    @Override
    public void addRooms(String room) {
        this.rooms.add(room);
    }

    @Override
    public void addFloors(String floor) {
        this.floors.add(floor);
    }

    @Override
    public List<String> getRooms() {
        return this.rooms;
    }

    @Override
    public List<String> getFloors() {
        return this.floors;
    }

    @Override
    public void show() {
        System.out.println("住宅房间：" + this.rooms.toString() + "；" + "楼层：" + this.floors.toString() + "。");
    }
}

/***
 * @ClassName Builder
 * @Description 建筑工人抽象
 * @Author Meiduo Ke
 * @Date 11:25 11:25
 */
interface Builder {
    void buildRoom(int n);

    void buildFloor(int m);

    Building getResult();
}

/***
 * @ClassName ResidenceBuilder
 * @Description 具体的住宅建筑工人
 * @Author Meiduo Ke
 * @Date 11:25 11:25
 */
class ResidenceBuilder implements Builder {

    private Building building;

    public ResidenceBuilder() {
        this.building = new ResidenceBuilding();
    }

    @Override
    public void buildRoom(int n) {
        building.addRooms(n + "号房间");
    }

    @Override
    public void buildFloor(int m) {
        building.addFloors(m + "层");
    }

    @Override
    public Building getResult() {
        return building;
    }
}

/***
 * @ClassName Designer
 * @Description 设计师
 * @Author Meiduo Ke
 * @Date 11:25 11:25
 */
class Designer {
    private Builder builder;

    public Designer(Builder builder) {
        this.builder = builder;
    }

    public Building build() {
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildRoom(3);
        builder.buildRoom(4);
        builder.buildFloor(1);
        builder.buildFloor(2);
        return builder.getResult();
    }

    public Building buildHigh() {
        for (int i = 1; i <= 100; i++) {
            builder.buildRoom(i);
            if (i % 10 == 0) {
                builder.buildFloor(i / 10);
            }
        }
        return builder.getResult();
    }
}
