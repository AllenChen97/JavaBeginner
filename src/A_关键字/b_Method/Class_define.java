package A_关键字.b_Method;

public class Class_define {
    public static void main(String[] args) {
        User u = new User();
        add(u);
        System.out.println(u.age);
    }
    public static void add(User a){
        a.age*=2;
    }
}

class User {
    int age = 10;
    public User(){
         System.out.println(age);
    }
}