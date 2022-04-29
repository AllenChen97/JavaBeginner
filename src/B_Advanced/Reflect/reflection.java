package B_Advanced.Reflect;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class reflection {
    public static void main(String[] args) throws Exception {
        Class s = Class.forName("java.lang.String");
////////////////////////////////////////////////////一、获取变量
        System.out.println("------------------------------------------------------>一、反编译变量");

        Field[] fields = s.getDeclaredFields();
        for (Field field: fields) {
            System.out.print(Modifier.toString(field.getModifiers())+" ");
            System.out.print(field.getType()+field.getName());
            System.out.println("");
        }

////////////////////////////////////////////////////二、获取方法
        System.out.println("------------------------------------------------------>二、反编译方法");
        Method[] methods = s.getDeclaredMethods();

        for (Method method: methods) {
            System.out.print(Modifier.toString(method.getModifiers())+" ");//修饰词

            System.out.print(method.getReturnType().getSimpleName()+" ");//方法返回类型

            System.out.print(method.getName()+" ");//方法名字


            Class[] params = method.getParameterTypes();//参数列表
            System.out.print("(");
            for (Class p: params) {
                System.out.print(p.getSimpleName()+" ");
            }
            System.out.print("){}");
            System.out.println("");
        }

////////////////////////////////////////////////////三、反编译类
        System.out.println("------------------------------------------------------>三、反编译类");
        System.out.print(Modifier.toString(s.getModifiers())+" class ");
        System.out.print(s.getSimpleName());

    }
}
