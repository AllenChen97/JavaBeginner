package C_算法.DataStructure.Graph;


import C_算法.DataStructure.LinearTable.Queue;


public class Graph{
    public int v;
    public int e;
    public Queue<Integer>[] adj;


    public Graph(int v) {
        this.v = v;
        this.e = 0;
        this.adj = new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }
    public int v(){
        return v;
    }
    public int e(){
        return e;
    }
    public void addEdge(int x, int y){
        adj[x].add(y);
        adj[y].add(x);
        e++;
    }

    public Queue<Integer> adj(int x){
        return adj[x];
    }
}
