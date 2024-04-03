package BKS;

import java.util.Arrays;

public class PGS_최대공약수와최소공배수 {
    // 20240404 00:33 ~ 00:37 (복습할 것)
    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        int[] answer = new int[2];
        // 1. 최대공약수와 최소공배수는 유클리드 호재법을 사용한다.
        int bigNum = Math.max(n, m);
        int smallNum = Math.min(n, m);

        // 2. 최대공약수를 구한다.
        answer[0] = gcd(bigNum, smallNum);

        // 3. 최소공배수를 구한다 -> 두 수의 곱 / 최대공약수
        answer[1] = (bigNum * smallNum) / answer[0];

        System.out.println(Arrays.toString(answer));
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) return b;

        return gcd(b, a % b);
    }
}
