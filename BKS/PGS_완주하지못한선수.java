package BKS;

import java.util.HashMap;

public class PGS_완주하지못한선수 {
    // 20240422 12:10 ~ 12:18
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        // 1. 참여자 명단을 담고 중복이름은 이전의 값에 +1을 한다.
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        // 2. 완주할 경우 -1을 한다. (value가 0인 경우 완주자이다.)
        for (String comp : completion) {
            map.put(comp, map.get(comp) - 1);
        }

        // 3. value가 0이 아닌 경우 완주못한 사람이므로 answer에 담는다.
        // 여기서, 의문은 완주 못한 사람은 한 명 뿐인가..?
        for (String key : map.keySet()) {
            if (map.get(key) != 0) answer = key;
        }

        System.out.println(answer);
    }
}
