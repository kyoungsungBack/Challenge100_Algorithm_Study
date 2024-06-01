package BKS.복습;

import java.util.HashMap;

public class PGS_완주하지못한선수 {
    // 20240422 12:10 ~ 12:18
    // 20240601 16:54 ~ 17:11
    public static void main(String[] args) {
        String answer = "";
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        HashMap<String, Integer> map = new HashMap<>();

        // 1. 쳠여자들의 명단을 map에 담는다.
        for (String par : participant) {
            map.put(par, map.getOrDefault(par, 0) + 1);
        }

        // 2. 완주한 인원의 수를 감소한다.
        for (String com : completion) {
            map.put(com, map.get(com) - 1);
        }

        // 3. 완주하지 못한 인원을 answer에 담는다.
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        System.out.println(answer);
    }
}
