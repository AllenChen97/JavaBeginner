package H_Algorithms.DataStructure.LinearTable;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>  {
    private Node head;
    private Node lastNode;
    private int N;

    public class Node{
        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Queue() {
        this.head = new Node(null,null);
        this.lastNode = null;
        N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void add(T v){
        if(lastNode == null){
            lastNode = new Node(v,null);
            head.next = lastNode;
        }
        else{
            Node oldLast = lastNode;
            lastNode = new Node(v,null);
            oldLast.next = lastNode;
        }
        N++;
    }

    public T remove(){
        if(isEmpty()) return null;

        Node oldFirst = head.next;
        head.next = oldFirst.next;

        N--;
        // 如果元素被删完需要重置lastNode = null
        if(isEmpty()) lastNode = null;
        return oldFirst.value;
    }

    @Override
    public Iterator<T> iterator(){
        return new QIterator();
    }


    private class QIterator implements Iterator{
        private Node n;

        public QIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.value;
        }
    }

}
