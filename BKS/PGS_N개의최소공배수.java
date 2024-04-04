package BKS;

import java.util.Arrays;

public class PGS_N개의최소공배수 {
    // 20240404 13:22 ~ 13:33 (복습할 것)
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        // 0. N개의 수의 최소공배수 구할 땐 수들에서 두 개씩 최소공배수를 구하여 최종 최소공배수를 구한다.
        // 1. 최소공배수를 구하는 법 -> 두 수의 곱 / 최대공약수

        int answer = arr[0];
        for (int i = 1 ; i < arr.length ; i++) {
            // 3. 맨 앞의 수부터 두개씩 최소공배수를 구하고 리턴받은 최소공배수를 다음 연산에 활용한다.
            answer = lcm(arr[i], answer);
        }

        System.out.println(answer);
    }
    // 최대공약수(gcd) 함수
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
    // 최소공배수(lcm) 함수
    public static int lcm(int a, int b) {
        // 2. 최소공배수를 구하기 위해 두 수의 최대공약수를 구한다.
        int bigNum = Math.max(a, b);
        int smallNum = Math.min(a, b);
        // 3. 두 수의 최소공배수를 구해서 반환한다..
        return (a * b) / gcd(bigNum, smallNum);
    }
}
