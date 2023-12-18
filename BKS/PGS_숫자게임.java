package BKS;

import java.util.Arrays;

public class PGS_숫자게임 {
    // 20231218 15:52 ~ 16:21
    public static void main(String[] args) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;

        while (j < B.length) {
            if (A[i] < B[j]) {
                answer++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        System.out.println(answer);
    }
}
