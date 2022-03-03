package Z_Exercise;

// 2 methods to reverse an array
class reverse {
//    public static void main(String[] args) {
//        int[] i = {22,11,55,11,33,0,99};
//        int[] reverse = new int[i.length];
//        for (int j = 0; j < i.length; j++) {
//            reverse[j] = i[i.length-j-1];
//        }
//
//        for (int k:reverse) {
//            System.out.println(k);
//        }
//    }

    public static void main(String[] args) {
        int[] i = {22,11,55,11,33,0,99};
        int start;
        int end = i.length-1;
        int temp;
        // exchange tye position
        for (start = 0; start < end; start++) {
            temp = i[start];
            i[start] = i[end];
            i[end] = temp;
            end--;
        }

        for (int k: i) {
            System.out.println(k);
        }
    }
}
