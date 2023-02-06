package prototypepattern;

import java.io.*;

/**
 * @ClassName SerializableSheep
 * @Description 深拷贝
 * @Author Meiduo Ke
 * @Date 2023/2/3 14:23
 * @Version 1.0
 */
public class SerializableSheep {
    public static void main(String[] args) {
        SerializableStudent student1 = new SerializableStudent("小明", 20, new SerializableStudent("小黄", 18, null));
        SerializableStudent student2 = (SerializableStudent) student1.clone();
        System.out.println("cs1 hashcode:" + student1.hashCode() + ",cs1 friend hashcode:" + student1.getFriend().hashCode());
        System.out.println("cs2 hashcode:" + student2.hashCode() + ",cs2 friend hashcode:" + student2.getFriend().hashCode());
        //
        // cs1 hashcode:325040804,cs1 friend hashcode:1846274136
        // cs2 hashcode:1915910607,cs2 friend hashcode:284720968
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
class SerializableStudent implements Serializable {
    private String name;
    private Integer age;
    private SerializableStudent friend;

    public SerializableStudent(String name, Integer age, SerializableStudent friend) {
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

    public SerializableStudent getFriend() {
        return friend;
    }

    public void setFriend(SerializableStudent friend) {
        this.friend = friend;
    }

    public Object clone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;

        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // assert <boolean表达式>
            // 如果<boolean表达式>为true，则程序继续执行。
            // 如果为false，则程序抛出AssertionError，并终止执行。
            assert bos != null;
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert oos != null;
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            assert bis != null;
            try {
                bis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            assert ois != null;
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "SerializableStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friend=" + friend +
                '}';
    }
}
