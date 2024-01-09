package BKS.복습;

import java.util.HashSet;

public class PGS_소수찾기 {
    // 20240109 17:23 ~ 17:47 18:10 ~ 18:18
    static HashSet<Integer> res;
    static int n;
    public static void main(String[] args) {
        int answer = 0;
        String numbers = "17";
        n = numbers.length();
        res = new HashSet<>();
        sol(0, numbers, new boolean[n]);

        System.out.println(res.size());
    }
    public static void sol(int num, String numbers, boolean[] visited) {
        if (isNum(num)) {
            res.add(num);
        }

        // 숫자 조각의 조합으로 소수인지 판별
        for (int i = 0 ; i < n ; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                String str = String.valueOf(num) + numbers.charAt(i);
                sol(Integer.parseInt(str), numbers, visited);
                visited[i] = false;
            }
        }
    }

    public static boolean isNum (int num) {
        if (num < 2) return false;

        for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
