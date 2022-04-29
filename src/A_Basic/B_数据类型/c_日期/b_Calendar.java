package A_Basic.B_数据类型.c_日期;

import java.util.Calendar;
/*
* 其他类：  java.time.Instant、LocalDate、LocalTime、LocalDateTime、ZoneDateTime
* */

//https://blog.csdn.net/wangdong5678999/article/details/81159690

public class b_Calendar {
    public static void main(String[] args) {
        //1. 获得Calendar 对象
        Calendar cal = Calendar.getInstance();
        System.out.println("1. " + cal.getTime());

        //2. 增加或减少
        cal.add(Calendar.DATE, -10);
        System.out.println("2. " + cal.getTime());

        //3. 给实例set时间
//        cal.set(2021, 6, 20, 00, 00, 00); //创建对象的方法
        cal.set(Calendar.YEAR,2018);
        cal.set(Calendar.MONTH,1); //1是二月
        cal.set(Calendar.DATE,1);
        cal.roll(Calendar.DATE,-1);

        //4. 用2018.01.01 减一天 计算当月有多少天
        int maxDate = cal.get(Calendar.DATE);
        System.out.println("4. " + maxDate);
    }
}
