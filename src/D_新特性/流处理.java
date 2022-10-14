package D_新特性;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class 流处理 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 34);
        // 统计 1
        list.stream().mapToInt(x -> x).sum();
        list.stream().mapToInt(x -> x).max();
        list.stream().mapToInt(x -> x).min();
        list.stream().mapToInt(x -> x).average();
        list.stream().count();

        // 统计 2
        IntSummaryStatistics stats = list.stream().mapToInt((x) -> x).summaryStatistics();
        stats.getSum();
        stats.getCount();
        stats.getMax();
        stats.getAverage();

        // 字符合并
        List<String> str = Arrays.asList("1", "2", "2", "3", "34");
        System.out.println(str.stream().collect(Collectors.joining(", ")));
        // 并行流
        list.parallelStream().count();
        list.parallelStream().max((a,b)->a-b);
        list.parallelStream().min((a,b)->a-b);

        // 随机数
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

    }
}
