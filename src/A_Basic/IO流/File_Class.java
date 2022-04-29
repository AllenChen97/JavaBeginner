package _16_IOStream;

import java.io.File;
import java.io.IOException;

public class File_Class {
    public static void main(String[] args) throws IOException  { //createNewFile要抛IO异常
        File file = new File("F:\\ShadowRocket");

        /////////////////////////////////////////////////////////一、增
        if(!file.exists()){
            file.mkdir();
            file.mkdirs(); //创建多层目录
            file.createNewFile();
        }

        /////////////////////////////////////////////////////////二、删
        if(!file.exists()){
            file.delete();
        }

        /////////////////////////////////////////////////////////三、查

        System.out.println(file.exists());              //是否存在
        System.out.println(file.isFile());              //是否文件
        System.out.println(file.isDirectory());         //是否目录文件

        System.out.println(file.getAbsolutePath());     //绝对路径
        System.out.println(file.getName());             //文件名
        System.out.println(file.getParent());           //父目录
        System.out.println(file.length());              //获取文件大小
        System.out.println(file.lastModified());        //获取最后修改时间

        //获取目录下的每一个文件路径
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }

        /////////////////////////////////////////////////////////四、改
        if(!file.exists()){
            File file1 = new File("F:\\Shit");
            file.renameTo(file1);
        }

    }
}
