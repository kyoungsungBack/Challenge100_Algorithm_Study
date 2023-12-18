package BKS;

import java.util.HashSet;
import java.util.Set;

public class PGS_소수찾기 {
    // 20231218 11:37 ~ 12:41
    static Set<Integer> list;

    public static void main(String[] args) {
        String numbers = "17";
        int answer = 0;
        list = new HashSet<>();
        int len = numbers.length();

        // 숫자열을 쪼개서 집합 만들기
        sol("", numbers, new boolean[len]);

        // 쪼갠 집합에서 소수 찾기
        for (int num : list) {
            boolean flag = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag && num != 0 && num != 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void sol(String num, String numbers, boolean[] visited) {

        if (!"".equals(num)) {
            list.add(Integer.parseInt(num));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                sol(num + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }

    }
}
