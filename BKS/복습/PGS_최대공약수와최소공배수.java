package BKS.복습;

import java.util.Arrays;

public class PGS_최대공약수와최소공배수 {
    // 20240811 16:14 ~ x (복습할 것)
    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = (n * m) / answer[0];

        System.out.println(Arrays.toString(answer));
    }
    // 1. 최대공약수 함수
    //    -> a: 큰 수 b: 작은 수 를 넣지 않더라도 다음 재귀에서 역전된다.
    public static int gcd(int a, int b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }
}
