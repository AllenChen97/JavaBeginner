package C_封装多态继承_面试.d_Object_methods;

import java.util.Objects;

public class Obj_toString {
    int a=1;
    int b=2;

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public static void main(String[] args) {
        System.out.println();


    }
}
