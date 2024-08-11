package BKS.복습;

public class PGS_숫자카드나누기 {
    // 20240804 17:39 ~ 18:07
    // 20240811 15:50 ~ 16:12
    public static void main(String[] args) {
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        int answer = 0;

        // 0. A,B 배열의 최대공약수를 찾기 위한 변수 초기화.
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 1. 각 A,B 배열의 최대공약수를 찾는다.
        for (int i = 1 ; i < arrayA.length ; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 2.1. gcdA로 arrayB를 나눌 수 있는지 확인한다.
        for (int numB : arrayB) {
            if (numB % gcdA == 0) {
                gcdA = 0;
                break;
            }
        }
        answer = gcdA;

        // 2.2. gcdB로 arrayA를 나눌 수 있는지 확인한다.
        for (int numA : arrayA) {
            if (numA % gcdB == 0) {
                gcdB = 0;
                break;
            }
        }

        // 3. 조건을 만족하는 최대의 수를 answer에 담는다.
        answer = Math.max(answer, gcdB);
        System.out.println(answer);
    }
    public static int gcd(int a, int b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }
}
