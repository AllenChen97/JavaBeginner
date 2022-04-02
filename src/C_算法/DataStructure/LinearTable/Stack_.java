package C_算法.DataStructure.LinearTable;

public class Stack_ {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        ListNode head = ListNode.reverseList(l1);

        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, tmp;

        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
