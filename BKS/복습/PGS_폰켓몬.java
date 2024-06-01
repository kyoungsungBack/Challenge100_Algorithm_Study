package BKS.복습;

import java.util.HashMap;

public class PGS_폰켓몬 {
    // 20240422 11:51 ~ 12:07
    // 20240601 16:19 ~ 16:35
    public static void main(String[] args) {
        int answer = 0;
        int[] nums = {3, 1, 2, 3};
        // 최대로 많이 가질 수 있는 종류의 수를 구한다.
        // (nums / 2)개 만큼 가질 수 있다.
        int cnt = nums.length / 2;

        HashMap<Integer, Integer> map = new HashMap<>();
        // 1. 현재 nums의 포켓몬 종류의 수를 센다.
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. answer가 될 수 있는 최대 개수는 (nums / 2)개 이다.
        // 2.1. (nums / 2) 가 현재 포켓몬 종류의 수 보다 작거나 같으면
        //      (nums / 2) 가 될 수 있는 최대 개수 이다.
        if (cnt <= map.size()) {
            answer = cnt;
        } // 2.2. (nums / 2) 가 현재 포켓몬 종류의 수 보다 클 경우
        //      현재 포켓몬 종류의 수 만큼 최대로 가질 수 있다.
        else {
            answer = map.size();
        }
    }
}
