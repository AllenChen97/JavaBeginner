package A_Basic.D_新特性;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Lambda {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList();

        IntStream.range(0,10).forEach(arr::add);

        arr.stream()
                .filter(i -> i % 2==0)          // Predicate 断言式
                .map(i -> i * 2)                // Function
                .forEach(System.out::println);  // Consumer

//        System.out.println(Integer.valueOf("1100000",2));
    }
}
