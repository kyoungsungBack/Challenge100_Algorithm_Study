package BKS.복습;

import java.util.Arrays;

public class PGS_숫자게임 {
    // 20240108 10:10 ~ 10:23
    public static void main(String[] args) {
        int answer = 0;
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        Arrays.sort(A);
        Arrays.sort(B);

        // 투포인터 방식으로 접근한다.
        int idx1 = 0;
        int idx2 = 0;

        while (idx2 < B.length) {
            if (A[idx1] < B[idx2]) {
                idx1++;
                answer++;
            }
            idx2++;
        }
        System.out.println(answer);
    }
}
