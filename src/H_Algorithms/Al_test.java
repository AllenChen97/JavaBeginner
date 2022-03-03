
package H_Algorithms;

import H_Algorithms.DataStructure.LinearTable.Queue;

import java.util.*;

public class Al_test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);

        b1.next = b2;

//        ListNode n = getIntersectionNode(n1,n2);
        System.out.println(reverseWords("the sky  is blue"));


    }
    public static String reverseWords(String s) {
        String tmp = "";
        String[] arr = s.split(" ");
        int i = 0, j = arr.length-1;
        while(i<j){
            tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
        tmp = "";
        for(String str :arr) {
            if (str.equals(""))
                tmp += " ";
            else
                tmp += str + " ";
        }
        return tmp.trim();
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
