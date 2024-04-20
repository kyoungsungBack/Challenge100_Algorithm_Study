package BKS;

import java.util.HashMap;

public class PGS_의상 {
    // 20240419 17:07 ~ 17:53 (못품) -> 해시에 담고 방정식 풀이로 접근
    // 20240420 22:56 ~ 23:06 (복습)
    public static void main(String[] args) {
        int answer = 1;
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        // 0. 착용부위를 key로 하고 중복 횟수를 value로 map에 담는다.
        HashMap<String, Integer> map = new HashMap<>();

        // 1. map에 각 착용부위의 의상 개수를 더 한다.
        for (int i = 0 ; i < clothes.length ; i++) {
            // 1.1. getOrDefault을 통해 기존에 있는 키는 그때의 벨류 아니면 0을 반환한다.
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        // 2. map에서 방정식 공식에 따라 의상을 입을 수 있는 경우의 수를 계산한다.
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        answer -= 1;

        // 3. 만약 map의 개수가 1개일 경우 clothes길이 개수만큼 답이다.
        if (map.size() == 1) answer = clothes.length;

        System.out.println(answer);
    }
}
