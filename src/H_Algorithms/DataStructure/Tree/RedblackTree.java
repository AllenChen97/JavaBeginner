package H_Algorithms.DataStructure.Tree;

public class RedblackTree<Key extends Comparable<Key>,Value> {
    public Node root;
    public int N;

    public RedblackTree() {
        this.root = null;
        int N = 0;
    }
    public class Node{
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    // 通过 leftRotate, rightRotate, colorReverse 确保树平衡
    private boolean isRed(Node node){
        if (node == null) return false;
        return node.color;
    }
    private Node leftRotate(Node h){
        // 1. get right node x of h
        Node x = h.right;
        // 2. 让X的左节点 = h的右节点
        h.right = x.left;
        // 3. let h become x's left node!!
        x.left = h;
        // let x's color become h's color
        h.color = x.color;
        // let x color=true;
        x.color = true;
        return x;
    }
    private Node rightRotate(Node h){
        // get left node(x) of h
        Node x = h.left;
        // let right node of x be the right node of h
        h.left = x.right;
        // let h become x's left node!!
        x.right = h;
        // let x's color become h's color
        h.color = x.color;
        // let x color=true;
        x.color = true;
        return x;
    }
    private void colorReverse(Node h){
        h.color = true;
        h.left.color = false;
        h.right.color = false;
    }

    public void put(Key k, Value v){
        root = put(root, k, v);
        root.color = false;
    }

    private Node put(Node node, Key k, Value v){
        // default color = red
        if (node == null) return new Node(k, v,null,null,true);

        if (k.compareTo(node.key)>0){
            node.right = put(node.right, k, v);
        }
        else if (k.compareTo(node.key)<0){
            node.left = put(node.left, k, v);
        }
        else{
            node.value = v;
        }
        // leftRotate
        if(!isRed(node.left) && isRed(node.right)){
            node = leftRotate(node);
        }
        // rightRotate
        if(isRed(node.left) && isRed(node.left.left)){
            node = rightRotate(node);
        }
        // colorReverse
        if(isRed(node.left) && isRed(node.right)){
            colorReverse(node);
        }
        N++;
        return node;
    }

    //delete
    public void delete(Key k){
        delete(root, k);
        root.color = false;
    }
    private Node delete(Node node, Key k) {
        return null;
    }


    //searching
    public Value get(Key k) {
        return get(root, k);
    }

    private Value get(Node node, Key k){
        if (node == null) return null;
        if (k.compareTo(node.key)>0){
            return get(node.right, k);
        }
        else if (k.compareTo(node.key)<0){
            return get(node.left, k);
        }
        else{
            return node.value;
        }
    }

    public static void main(String[] args) {
        RedblackTree<Integer,String> r = new RedblackTree<>();
        r.put(20,"a");
        r.put(10,"b");
        r.put(5,"c");

        System.out.println(r.N + "个元素");

        System.out.println(r.get(20));
        r.delete(20);

        System.out.println(r.get(20));
        System.out.println(r.get(10));
        System.out.println(r.get(5));
    }
}
