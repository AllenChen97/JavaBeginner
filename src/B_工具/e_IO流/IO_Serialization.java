package _16_IOStream;

import java.io.*;
import java.util.List;
/*
* 注意 ：
* 参与序列化和反序列化的对象必须实现Serializable,Serializable里面啥都没有 只是个标志接口，JVM 看到这个接口会自动提供序列化版本号
* 对象内用transient修饰的变量，不参与序列化，反序列化后变量是其默认值（Int类型是0）
*
* 序列化版本号：
*   Java用类名和序列化版本号来区别类。缺点是：代码一改，编译时JVM会认为是一个全新的类，就不能把本地保存的对象反序列化了
* 优化：
*   凡是实现Serializable接口的，建议人为赋值一个固定的序列化版本号，不自动生产
*    private static final long SerialVersionUID=1L; //实现了Serializable接口后，对着类名按就自动出来

 * */
public class IO_Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        File file = new File("F:\\ShadowRocket");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file"));
        oos.writeObject(file);
        oos.flush();

        //一次序列化含多个对象的集合
        File[] files = file.listFiles();
        oos.writeObject(files);
        oos.flush();
        oos.close();

        //反序列化
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("file"));
        Object file_reser = ooi.readObject();

        //读取含多个对象的
        List<File> files1 = (List<File>)ooi.readObject();
        oos.writeObject(files);

        ooi.close();

    }
}
