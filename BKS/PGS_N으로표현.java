package BKS;

import java.util.HashSet;

public class PGS_N으로표현 {
    // 20240118 12:05 ~ 12:17(다시 풀 것)
    // 20240119 17:27 ~ 17:37
    public static void main(String[] args) {
        int answer = -1;
        int N = 5;
        int number = 12;
        // 1. 자료를 담을 구조로 HashSet 배열을 생각한다.
        // -> 배열의 크기는 N의 최대개수이다.
        // -> N의 인덱스 개수만큼으로 만들 수 있는 수를 저장한다.
        HashSet<Integer>[] set = new HashSet[9];

        int num = N;
        // 2. 각 배열에 HashSet 인스턴스를 생성하고 N을 i개 만큼 만들어서 세팅한다.
        for (int i = 1 ; i < 9 ; i++) {
            set[i] = new HashSet<>();
            set[i].add(num);
            num = num * 10 + N;
        }

        // 3. N의 i개 만큼으로 만들 수 있는 수를 저장한다.
        for (int i = 1 ; i < 9 ; i++) {
            for (int j = 1 ; j < i ; j++) {
                for (Integer a : set[j]) {
                    for (Integer b : set[i - j]) {
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        // 3.1. 분모가 0이면 나누기 연산 오류나므로 아닐 때만 나눈다.
                        if (a != 0 && b != 0) {
                            set[i].add(a / b);
                        }
                    }
                }
            }
        }

        for (int i = 1 ; i < set.length ; i++) {
            if (set[i].contains(number)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
