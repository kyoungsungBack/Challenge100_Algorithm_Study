package BKS.복습;

import java.util.HashMap;

public class PGS_의상 {
    // 20240601 18:26 ~ x
    public static void main(String[] args) {
        int answer = 0;
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        // 종류가 주어지고 각 종류의 개수가 있을 때 가능한 경우의 수
        // -> (a + 1)(b + 1)(c + 1) ... - 1 방정식으로 구한다.
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0 ; i < clothes.length ; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int cnt = 1;

        for (String key : map.keySet()) {
            cnt *= (map.get(key) + 1);
        }

        answer = cnt - 1;

        if (map.size() == 1) answer = clothes.length;

        System.out.println(answer);
    }
}
