package BKS;

import java.util.Arrays;
import java.util.Comparator;

public class PGS_가장큰수 {
    // 20240418 16:53 ~ 17:00 (복습)
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        String answer = "";
        String[] str = new String[numbers.length];

        // 1. 먼저 문자열로 비교하기 위해 문자열 배열 생성한다.
        for (int i = 0 ; i < numbers.length ; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // 2. 문자열 배열에서 두 요소씩 합쳐 큰 수를 앞으로 작은 수를 뒤로 정렬한다.
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        /* 아래는 Comparator를 이용한 정렬방법
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                System.out.println(Arrays.toString(str) + o1 + " " + o2);
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        */

        // 3. 정렬된 문자열을 하나씩 담아 답으로 반환한다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < str.length ; i++) {
            sb.append(str[i]);
        }
        answer = sb.toString();

        // 4. str배열의 첫 값이 0이면 배열의 모든 요소가 0이므로 0반환한다.
        if (str[0].equals("0")) answer = "0";

        System.out.println(answer);
    }
}
