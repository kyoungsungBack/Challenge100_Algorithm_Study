package BKS;

public class PGS_멀리뛰기 {
    // 20240404 13:41 ~ 13:46
    public static void main(String[] args) {
        int n = 4;
        long answer = 0;
        int[] arr = new int[2001];
        // 0. 멀리뛸 수 있는 칸의 증가하는 규칙은 피보나치 수열을 이룬다.
        // 1. 피보나치 수열 f(n) = f(n - 1) + f(n - 2) 을 이용한다.
        arr[1] = 1;
        arr[2] = 2;

        // 2. 피보나치 수열의 값에 1234567을 나눈 나머지를 배열에 담는다.
        for (int i = 3 ; i < 2001 ; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }

        // 3. n에 해당하는 값을 answer에 담고 반환한다.
        answer = arr[n];
        System.out.println(answer);
    }
}
