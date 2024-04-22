package BKS;

import java.util.HashMap;

public class PGS_폰켓몬 {
    // 20240422 11:51 ~ 12:07
    public static void main(String[] args) {
        int answer = 0;
        int[] nums = {3,3,3,2,2,4};

        HashMap<Integer, Integer> map = new HashMap<>();
        // 0. 가질 수 있는 폰켓몬 수
        int req = nums.length / 2;

        // 1. 일단 처음 들어온 포켓몬 수를 answer에 증가하고 0부터 시작하도록 한다.
        for (int num : nums) {
            if (map.get(num) == null) answer++;
            map.put(num, map.getOrDefault(num, -1) + 1);

            if (answer == req) break;
        }

        System.out.println(answer);
    }
}
