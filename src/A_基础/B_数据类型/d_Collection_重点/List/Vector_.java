package A_基础.B_数据类型.d_Collection_重点.List;

import java.util.Enumeration;
import java.util.Vector;


public class Vector_ {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("a");
        v.add("b");
        Enumeration e = v.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }
}
