package BKS.복습;

public class PGS_n진수게임 {
    // 20240302 19:05 ~ 19:34 복습
    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;
        String answer = "";
        String str = "";

        // 1. str에 필요한 숫자를 나열한다.
        //    이때, 진법변환은 Integer.toString(,) 사용
        for (int i = 0 ; i < t*m ; i++) {
            str += Integer.toString(i, n).toUpperCase();
        }

        // 2. 필요한 개수만큼 반복문을 돌고 나열된 숫자에서 필요한 번째만 answer에 담는다.
        while (answer.length() < t) {
            answer += str.charAt(p - 1);
            p += m;
        }

        System.out.println(answer);
    }
}
