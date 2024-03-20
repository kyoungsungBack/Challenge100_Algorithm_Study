package BKS;

public class PGS_2xn타일링 {
    // 20240319 21:14 ~ 10:03 (다시 풀이)

    public static void main(String[] args) {
        int n = 4;
        // 0. n을 숫자 1과 2로 만들 수 있는 경우의 수를 구한다.

        // 1. 문제의 규칙성을 찾으며 피포나치 수열임을 확인한다.
        // 2. 반복, 재귀, 동적계획법 중에 선택한다.
        // 3. 재귀를 사용할 경우 시간초가 발생하므로 동적계획법을 사용한다.
        // 4. 피보나치수열 F(n) = F(n - 1) + F(n - 2)가 성립한다.
        int[] DP = new int[60001];
        DP[1] = 1;
        DP[2] = 2;

        for (int i = 3 ; i <= n ; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 1000000007;
        }

        System.out.println(DP[n]);
    }
}
