package C_算法;


/*
* 初始化 都等于第一个
* 如果下一个比lowest大：就将其更新profit和highest
* 如果下一个更小，就临时lowest? 如果下面有更大的数 让 profit更大 就更新 否则都是临时，原来的三个数值不变
* */
public class test {
    public static void main(String[] args) {
        int i = 18822;
        String s = i + "";

//        String ss = s.substring(1,3);
//        System.out.println(ss);
//        System.out.println(ss.compareTo("26"));

        System.out.println(translateNum(i));
    }

    public static int translateNum(int num) {
        String s = num + "";
        int length = s.length();
        if (length < 0) return 0;

        int[] arr = new int[length];
        arr[0] = 1;
        for(int i = 1; i < length; i++){
            if (s.substring(i-1,i).compareTo("0")==0 || s.substring(i-1,i+1).compareTo("25") > 0)
                arr[i] = arr[i-1];
            else
                arr[i] = arr[i-1] * 2;
        }
        return arr[length-1];
    }
}
