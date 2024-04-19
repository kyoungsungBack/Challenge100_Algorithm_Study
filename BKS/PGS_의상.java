package BKS;

import java.util.HashMap;

public class PGS_의상 {
    // 20240419 17:07 ~ 17:53 (못품) -> 해시에 담고 방정식 풀이로 접근
    public static void main(String[] args) {
        int answer = 0;
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        // 1. 착용부위를 key로 하고 중복 횟수를 value로 map에 담는다.
        HashMap<String, Integer> map = new HashMap<>();

        // 2. getOrDefault를 통해 처음에 없던 값은 0 + 1이 되도록한다.
        for (int i = 0 ; i < clothes.length ; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        // 3.1. 종류가 두 개 이상이면 아래와 같은 공식에 의해 경우의 수가 생성된다.
        // 두 개 이상의 종류를 골라입는 경우의 수
        // a + b + c + ab + ac + bc + abc = (a + 1)(b + 1)(c + 1) - 1
        if (map.size() != 1) {
            int num = 1;

            for (String key : map.keySet()) {
                num *= map.get(key) + 1;
            }
            answer += num - 1;
        } // 3.2. 만약 종류가 하나이면 옷 종류만큼 경우의 수가 생성된다.
        else {
            answer = clothes.length;
        }

        System.out.println(answer);
    }
}
