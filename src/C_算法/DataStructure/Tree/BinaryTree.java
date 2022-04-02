package C_算法.DataStructure.Tree;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    public Node root;
    public int N;

    public BinaryTree() {
        this.root = null;
        int N = 0;
    }
    public class Node{
        public Key key;
        public Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    //insert
    public void put(Key k, Value v){
        root = put(root, k, v);
    }

    private Node put(Node node, Key k, Value v){
        if(node == null){
            N++;
            return new Node(k,v,null,null);
        };

        if(k.compareTo(node.key) > 0){
            node.right = put(node.right, k, v);
        }
        else if (k.compareTo(node.key) < 0){
            node.left = put(node.left, k, v);
        }
        else {
            node.value = v;
        }
        return node;
    }

    //delete
    public void delete(Key k){
        delete(root, k);
    }

    private Node delete(Node node, Key k) {
        if (node == null) return null;

        if(k.compareTo(node.key) > 0){
            node.right = delete(node.right, k);
        }
        else if (k.compareTo(node.key) < 0){
            node.left = delete(node.left, k);
        }
        else {
            //找到该节点之后进行删除
            // 1.无子节点 或 单个子节点
            if(node.right == null) return node.left;
            if(node.left == null) return node.right;

            // 2.双子节点: 右子树的最小节点来代替!
            // 找到最小节点 及其父节点，给及父节点删除与最小节点的关系（有可能处于左/右子树）
            Node minNodeFather = node;
            Node minNode = node.right;

            while(true){
                // 2.1. 有左子树的话就一直遍历下去
                if(minNode.left != null){
                    minNodeFather = minNode;
                    minNode = minNode.left;
                }
                // 2.2. 如果右子树只有1个元素（没有叶节点了），就让minNodeFather的右子树断开
                else{
                    if(minNodeFather == node) {
                        minNodeFather.right = null;
                    }else{
                        minNodeFather.left = null;
                    }
                    break;
                }
            }

            // 3.用最小节点minNode 来代替node节点
            minNode.left = node.left;
            minNode.right = node.right;
            node = minNode;
        }
        // 4. 把修改好的node返回给上面两个if进行迭代
        return node;
    }


    //searching
    public Value get(Key k){
        return get(root, k);
    }

    private Value get(Node node, Key k){
        if(node == null) return null;

        if(k.compareTo(node.key) > 0){
            return get(node.right, k);
        }
        else if (k.compareTo(node.key) < 0){
            return get(node.left, k);
        }
        else {
            return node.value;
        }
    }

    public void frontLoop(){
        frontLoop(root);
    }

    public void frontLoop(Node node){
        if (node==null) return;
        System.out.print(node.value + " ");
        frontLoop(node.left);
        frontLoop(node.right);
    }

    public void midLoop(){
        midLoop(root);
    }

    public void midLoop(Node node){
        if (node==null) return;
        midLoop(node.left);
        System.out.print(node.value + " ");
        midLoop(node.right);
    }

    public void backLoop(){
        backLoop(root);
    }

    public void backLoop(Node node){
        if (node==null) return;
        backLoop(node.left);
        backLoop(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        BinaryTree<Integer,String> t = new BinaryTree<>();
        t.put(20,"a");
        t.put(10,"b");
        t.put(5,"c");

        t.put(15,"d");
        t.put(12,"e");
        t.put(18,"f");

        System.out.println(t.N + "个元素");
        t.frontLoop();
        System.out.println();
        t.midLoop();
        System.out.println();
        t.backLoop();
        System.out.println();

        t.delete(15);
        System.out.println(t.root.left.value);
        System.out.println(t.root.left.left.value);
        System.out.println(t.root.left.right.value);
        System.out.println(t.root.left.right.left.value);
        System.out.println(t.root.left.right.right);
    }
}
