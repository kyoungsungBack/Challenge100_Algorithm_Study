package BKS.복습;

import java.util.Arrays;

public class PGS_HIndex {
    // 20240305 15:31 ~ 51 16:08 ~ 16:30 (20 + 22 = 44분)
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;
        // 1. 가장 큰 수를 찾기위해 오름차순으로 정렬한다.
        Arrays.sort(citations);

        int idx = citations.length - 1;
        int cnt = citations[idx];

        // 2. H-Index로 가능한 수와 citations배열의 수를 비교하여
        //    최대의 H-Index를 찾는다.
        for (int i = 0 ; i <= cnt ; i++) {
            int cntMax = 0;
            int cntMin = 0;

            for (int cur : citations) {
                if (i < cur) {
                    cntMax++;
                } else if (i == cur) {
                    cntMax++;
                    cntMin++;
                } else {
                    cntMin++;
                }
            }
            // 3. h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용된 경우
            if (i <= cntMax && i >= cntMin) {
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
