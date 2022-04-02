package A_基础.B_数据类型.d_Collection_重点.List;


import java.util.LinkedList;

/** LinkedList
 *  因继承了Deque，可以当做队列使用
 * */
public class LinkedList_{
    public static void main(String[] args) {

        System.out.println("\n<--------------- 1.链表 --------------->");
        LinkedList ll= new LinkedList();
        ll.add(3);
        ll.add(2);
        ll.add(1);
        while (!ll.isEmpty()){
            System.out.print(ll.remove() + " ");
        }

        System.out.println("\n<--------------- 2.栈Stack --------------->");
        LinkedList stack = new LinkedList();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("element(): " + stack.element());
        System.out.println("peek(): " + stack.peek());
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

        System.out.println("\n<--------------- 3.队列Queue --------------->");
        LinkedList queue= new LinkedList();
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
    }
}
