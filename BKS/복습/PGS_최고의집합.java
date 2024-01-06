package BKS.복습;

import java.util.Arrays;

public class PGS_최고의집합 {
    // 20240106 22:04 ~ 21:14
    public static void main(String[] args) {
        int n = 2;
        int s = 9;

        int[] answer = {};
        int mok = s / n;
        int mod = s % n;

        if (n > s) {
            System.out.println(-1);
            //return new int[]{-1};
        }

        answer = new int[n];
        Arrays.fill(answer, mok);

        int i = 0;
        while (mod != 0) {
            answer[i++] += 1;
            mod--;
        }

        Arrays.sort(answer);

        System.out.println(Arrays.toString(answer));
    }
}
