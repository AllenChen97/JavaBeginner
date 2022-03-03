package H_Algorithms.DataStructure.Graph;

import H_Algorithms.DataStructure.LinearTable.Queue;

import java.util.ArrayList;

public class BoardFirstSearching {
    public int count;
    public boolean[] marked;
    public Queue<Integer> waitSearch;

    public BoardFirstSearching(Graph g, int x) {
        this.count = 0;
        this.marked = new boolean[g.v];
        this.waitSearch = new Queue<Integer>();

        System.out.println("开始遍历无向图：");
        bfs2(g, x);
    }

    /**
     * bfs为黑马视频的做法，但遍历顺序与深度优先一致，并不符合广度优先的规则；
     *
     * bfs2为自己根据广度优先的理解进行改写的代码。
     *
     * */
    public void bfs(Graph g, int x){
        marked[x] = true;
        waitSearch.add(x);
        while(!waitSearch.isEmpty()){
            Integer wait = waitSearch.remove();
            for (Integer w : g.adj(wait)) {
                if(!marked[w]){
                    System.out.println("walked: " + w);
                    bfs(g, w);
                }
            }
        }
        count++;
    }

    public void bfs2(Graph g, int x){
        marked[x] = true;
        for (Integer w : g.adj(x)) {
            if(!marked[w]){
                System.out.println("walked: " + w);
                waitSearch.add(w);
                marked[w] = true;
                count++;
            }
        }

        while(!waitSearch.isEmpty()){
            Integer wait = waitSearch.remove();
//            System.out.println("dequeue: " + wait);
            bfs2(g, wait);
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(13);
        g.addEdge(0,5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,6);
        g.addEdge(5,3);
        g.addEdge(5,4);
        g.addEdge(3,4);
        g.addEdge(4,6);

        g.addEdge(7,8);
        System.out.println("The number of edge: " + g.e);

        // g.adj is a Queue which override the Iterator
        for (int i:g.adj(5)) {
            System.out.print(i + " ");
        }

        BoardFirstSearching b = new BoardFirstSearching(g,0);
        System.out.println("the v connect with 0: " + b.count);

        System.out.println("if 5 is connect with 0: " + b.marked[5]);
        System.out.println("if 7 is connect with 0: " + b.marked[7]);

    }
}
