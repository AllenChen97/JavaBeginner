package B_Advanced.Concurrent_exercise;

public class Client {

    Pair p;
    String msg;

    public Pair getP() {
        return p;
    }

    public void setP(Pair p) {
        this.p = p;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Client(Pair p, String msg) {
        this.p = p;
        this.msg = msg;
    }

}
