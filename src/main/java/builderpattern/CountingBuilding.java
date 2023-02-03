package builderpattern;

import java.util.List;

// 建筑造价
// 如果需要对建设的造价进行统计，可以新建一个统计造价的 CountingBuilder ，将这个 CountingBuilder 作为参数传给设计师，则可以方便的得到我们想要的结果，代码如下
public class CountingBuilding implements Building {
    private double countingRooms;
    private double countingFloors;

    public CountingBuilding() {
        this.countingRooms = 0;
        this.countingFloors = 0;
    }

    @Override
    public void addRooms(String room) {
        countingRooms += Double.parseDouble(room);
    }

    @Override
    public void addFloors(String floor) {
        countingFloors += Double.parseDouble(floor);
    }

    @Override
    public List<String> getRooms() {
        return null;
    }

    @Override
    public List<String> getFloors() {
        return null;
    }

    @Override
    public void show() {
        System.out.println("造价为：" + (countingRooms + countingFloors));
    }
}

// 统计造价的财务人员（属于另一种类型建筑工人）
class CountingBuilder implements Builder {
    private Building building;

    public CountingBuilder() {
        this.building = new CountingBuilding();
    }

    @Override
    public void buildRoom(int n) {
        if (n < 10) {
            building.addRooms(85.2 + "");
        } else if (10 <= n && n < 50) {
            building.addRooms(62.2 + "");
        } else {
            building.addRooms(48.7 + "");
        }
    }

    @Override
    public void buildFloor(int m) {
        if (m < 4) {
            building.addFloors(245.0 + "");
        } else if (4 <= m && m < 12) {
            building.addFloors(278.0 + "");
        } else {
            building.addFloors(297.0 + "");
        }
    }

    @Override
    public Building getResult() {
        return building;
    }
}
