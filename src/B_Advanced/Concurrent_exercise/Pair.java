package B_Advanced.Concurrent_exercise;

public class Pair implements Comparable<Pair> {
    private int a;
    private int b;

    public Pair(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public int compareTo(Pair o) {
        Double distance =  Math.sqrt(Math.pow(this.a,2) + Math.pow(this.b,2));
        Double distance_o =  Math.sqrt(Math.pow(o.getA(),2) + Math.pow(o.getB(),2));

        return distance.compareTo(distance_o);
    }
}
