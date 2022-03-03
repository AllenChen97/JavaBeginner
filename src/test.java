
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
//        "abcabcd"
        System.out.println(test.length("dvdf"));
    }
    public static int length(String s){
        int len = 0, min = 0;
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> m = new HashMap<>();
        m.values();
        for (int i = 0; i < chars.length; i++) {
            // non-repeat
            if(!m.containsKey(chars[i])){
                m.put(chars[i], i);
                if (i - min + 1 > len) len = i - min + 1;
            }
            else {
            // repeat
                if (i - min > len) len = i - min;
                min = i;
                m.put(chars[i], i);
            }
        }
        return len;
    }
}

