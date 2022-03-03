package B_工具.c_日期;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// https://www.runoob.com/java/java-date-time.html

public class a_Date {
    public static void main(String[] args) throws ParseException {
        //1. 当前时间
        Date d = new Date();
        System.out.println("1. " + d);

        System.out.println("--------------以下是 printf 的使用-----------");
        /* 2. printf的使用
        转  换  符       说    明                    示    例
            c       包括全部日期和时间信息             星期六 十月 27 14:21:20 CST 2007
            F       "年-月-日"格式                   2007-10-27
            D       "月/日/年"格式                   10/27/07
            r       "HH:MM:SS PM"格式（12时制）       02:25:51 下午
            T       "HH:MM:SS"格式（24时制）          14:28:16
            R       "HH:MM"格式（24时制）             14:28
        */
        System.out.printf("全部日期和时间信息：%tc%n",d);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",d);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",d);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",d);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",d);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",d);

        System.out.println("--------------以下是 SimpleDateFormat 格式化时间-----------");

        //3. SimpleDateFormat 格式化时间
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("2. " + f.format(d));

        System.out.println("--------------以下是 其他日期计算-----------");

        //4. 文本转Date对象
        Date d1 = f.parse("2021-10-30 06:40:48");
        System.out.println(d1);


        //5. 日期计算 (一天前) d.gettime() 毫秒
        System.out.println("4. " + f.format(d.getTime() - 1000*60*60*24));

        //6.计算运行时间
        long start_time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
        }
        long end_time = System.currentTimeMillis();

        System.out.println("5. 程序耗时" + (end_time - start_time) + "秒");





    }
}
