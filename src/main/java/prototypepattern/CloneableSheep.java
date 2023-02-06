package prototypepattern;

/**
 * @ClassName CloneableSheep
 * @Description 浅拷贝
 * @Author Meiduo Ke
 * @Date 2023/2/3 14:23
 * @Version 1.0
 */
public class CloneableSheep {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneableStudent student1 = new CloneableStudent("小明", 20, new CloneableStudent("小黄", 18, null));
        CloneableStudent student2 = (CloneableStudent) student1.clone();
        System.out.println("cs1 hashcode:" + student1.hashCode() + ",cs1 friend hashcode:" + student1.getFriend().hashCode());
        System.out.println("cs2 hashcode:" + student2.hashCode() + ",cs2 friend hashcode:" + student2.getFriend().hashCode());
        // cs1 hashcode:460141958,cs1 friend hashcode:1163157884
        // cs2 hashcode:1956725890,cs2 friend hashcode:1163157884
    }
}

/**
 * @ClassName CloneableSheep
 * @Description 浅拷贝
 * 需要重写clone方法
 * @Author Meiduo Ke
 * @Date 2023/2/3 14:23
 * @Version 1.0
 */
class CloneableStudent implements Cloneable {
    private String name;
    private Integer age;
    private CloneableStudent friend;

    public CloneableStudent(String name, Integer age, CloneableStudent friend) {
        this.name = name;
        this.age = age;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public CloneableStudent getFriend() {
        return friend;
    }

    public void setFriend(CloneableStudent friend) {
        this.friend = friend;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "CloneableStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friend=" + friend +
                '}';
    }
}
