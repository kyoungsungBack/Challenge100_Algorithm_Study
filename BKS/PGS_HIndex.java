package BKS;

import java.util.Arrays;

public class PGS_HIndex {
    // 20240120 17:35 ~ 18:14
    public static void main(String[] args) {
        int answer = 0;
        int[] citations = {3, 0, 6, 1, 5};

        // 1. citations배열을 오름차순으로 정렬한다.
        Arrays.sort(citations);
        int max = citations[citations.length - 1];

        // 2. 배열에서 제일 큰 인용횟수 만큼 반복하면서 조건에 맞게 카운트한다.
        for (int i = 0 ; i <= max ; i++) {
            int maxCnt = 0;
            int minCnt = 0;
            for (int j = 0 ; j < citations.length ; j++) {
                if (i <= citations[j]) {
                    maxCnt++;
                }
                minCnt = citations.length - maxCnt;
            }

            if (i <= maxCnt && i >= minCnt) {
                answer = Math.max(answer, i);
            }
        }
        System.out.println(answer);
    }
}
