package BKS.복습;

import java.util.HashSet;

public class PGS_N으로표현 {
    // 20240305 12:34 ~ 12:40 13:40 ~ 14:40 (다시 복습)
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        int answer = -1;
        HashSet<Integer>[] set = new HashSet[9];

        // 1. 1 ~ 8개의 N으로 만들 수 있는 수를 담을 그릇을 준비한다.
        //    이때, 사칙연산이 안들어간 연속된 수도 만들어서 미리 담는다.
        int num = N;
        for (int i = 1 ; i < 9 ; i++) {
            set[i] = new HashSet<>();
            set[i].add(num);
            num = num * 10 + N;
        }

        // 2. 이중 for each문을 통해 i개로 만들 수 있는 수를 set에 담는다.
        for (int i = 1 ; i < 9 ; i++) {
            for (int j = 1 ; j < i ; j++) {
                for (Integer a : set[j]) {
                    for (Integer b : set[i - j]) {
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);

                        // 2.1. 분모가 음수이면 exception이 발생한다.
                        if (b != 0) {
                            set[i].add(a / b);
                        }
                    }
                }
            }
        }

        for (int i = 1 ; i < 9 ; i++) {
            if (set[i].contains(number)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
