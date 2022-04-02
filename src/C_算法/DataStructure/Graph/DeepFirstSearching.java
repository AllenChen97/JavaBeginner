package C_算法.DataStructure.Graph;

public class DeepFirstSearching {
    public int count;
    public boolean[] marked;

    public DeepFirstSearching(Graph g, int x) {
        this.count = 0;
        this.marked = new boolean[g.v];
        dfs(g, x);
    }

    public void dfs(Graph g, int x){
        marked[x] = true;
        for (Integer w : g.adj(x)) {
            if(!marked[w]){
                System.out.println("walked: " + w);
                dfs(g, w);
            }
        }
        count++;
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
//        for (int i:g.adj(6)) {
//            System.out.print(i + " ");
//        }
//
        DeepFirstSearching d = new DeepFirstSearching(g,0);
//        System.out.println("the v connect with 0: " + d.count);
//
//        System.out.println("if 5 is connect with 0: " + d.marked[5]);
//        System.out.println("if 7 is connect with 0: " + d.marked[7]);

    }
}
