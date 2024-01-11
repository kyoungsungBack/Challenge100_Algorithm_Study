package BKS.복습;

public class PGS_예상대진표 {
    // 20240111 10:31 ~ 11:36
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        /* 풀이1. double 사용법
        int answer = 1;
        double A = a;
        double B = b;
        // 1. 두 명의 ceil 값이 같을 때 까지 반복한다
        while (Math.ceil(A / 2) != Math.ceil(B / 2)) {
            A = Math.ceil(A / 2);
            B = Math.ceil(B / 2);
            answer++;
        }*/

        // 풀이2. int 사용법
        int answer = 0;

        while (a != b) {
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);
            answer++;
        }
        System.out.println(answer);
    }
}
