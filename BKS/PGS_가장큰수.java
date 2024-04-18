package BKS;

import java.util.Arrays;
import java.util.Comparator;

public class PGS_가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        String[] arr = new String[numbers.length];

        // 1. String 배열로 변경한다.
        for (int i = 0 ; i < numbers.length ; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2. 정렬한다.
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();
        //if (arr[0].equals("0")) return "0";

        for (String str : arr) {
            sb.append(str);
        }
        System.out.println(sb.toString());
    }
}
