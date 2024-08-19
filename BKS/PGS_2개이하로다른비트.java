package BKS;

import java.util.Arrays;

public class PGS_2개이하로다른비트 {
    // 20240818 못품
    // 20240819 11:50 ~ 12:07

    /*
        **추가 공부 필요한 Collection method**
        Long.valueOf(String 타입의 수, n진수) : n진수인 String 수를 10진수(Long)로 반환
        Long.parseLong(String 타입의 수, n진수) : n진수인 String 수를 10진수(long)로 반환
        Long.toString(10진수, n진수) : n진수로 변환 후 String 으로 반환
        Long.toBinaryString(10진수) : 2진수 변환 후 String 으로 반환
        String.setCharAt(idx, 넣을 값) : idx에 Char 타입 삽입
        String.deleteCharAt(지울 idx) : idx에 해당하는 Char 삭제
    */

    public static void main(String[] args) {
        long[] numbers = {2, 7};
        long[] answer = new long[numbers.length];

        // 1. 현재 배열의 수 중에 조건을 만족하는 수를 찾는다.
        for (int i = 0 ; i < numbers.length ; i++) {
            // 2. 현재 수를 2진법으로 변환한다.
            StringBuilder cur = new StringBuilder(Long.toBinaryString(numbers[i]));

            // 3.1. 현재 수가 짝수인 경우,
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } // 3.2. 홀수인 경우,
            else {
                // 4. 01을 포함하는지 아닌지(1로만 구성된 경우)를 찾는다.
                if (cur.toString().contains("01")) {
                    int len = cur.length();
                    // 4.1. 맨처음 01을 10으로 대체 후 반복문 종료
                    for (int j = len ; j > 0 ; j--) {
                        if (cur.substring(j - 2, j).equals("01")) {
                            cur.setCharAt(j - 1, '0');
                            cur.setCharAt(j - 2, '1');
                            break;
                        }
                    }
                } // 4.2. 1로 구성된 경우 가장 앞자리를 지우고 10으로 대체
                else {
                    cur.deleteCharAt(0);
                    cur.insert(0, "10");
                }
                answer[i] = Long.valueOf(cur.toString(), 2);
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
