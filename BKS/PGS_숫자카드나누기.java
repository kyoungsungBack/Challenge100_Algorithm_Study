package BKS;

public class PGS_숫자카드나누기 {
    // 20240717 22:58 ~ x
    // 20240722 22:58 ~ x(복습하기)
    public static void main(String[] args) {
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        int answer = 0;

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 각 배열의 최대공약수를 구한다.
        for (int i = 1 ; i < arrayA.length ; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 나눌 수 없으면 true이고 가장 큰 값을 찾는다.
        if (isDivide(arrayA, gcdB)) {
            if (answer < gcdB) {
                answer = gcdB;
            }
        }

        if (isDivide(arrayB, gcdA)) {
            if (answer < gcdA) {
                answer = gcdA;
            }
        }

        System.out.println(answer);

    }
    public static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    public static boolean isDivide(int[] arr, int num) {
        for (int n : arr) {
            if (n % num == 0) return false;
        }
        return true;
    }
}
