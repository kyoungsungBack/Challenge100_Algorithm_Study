package BKS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PGS_오픈채팅방 {
    // 20240211 19:53 ~ 20:53
    public static void main(String[] args) {
        String[] answer;
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        HashMap<String, String> map = new HashMap<>(); // 변경된 닉네임을 관리한다.
        ArrayList<String[]> order = new ArrayList<>(); // 들어오고 나가는 순서를 관리한다.

        // 1. L, E, C을 분리하여 map과 order에 넣는다.
        //    map은 E와 C일 때만 저장하고
        //    order는 E와 L일 때만 저장한다.
        for (int i = 0 ; i < record.length ; i++) {
            String[] user;
            if (record[i].charAt(0) == 'L') {
                // 배열크기 2
                user = record[i].split(" ");
                order.add(new String[]{user[0], user[1]});
            } else if (record[i].charAt(0) == 'E') {
                // 배열크기 3
                user = record[i].split(" ");
                map.put(user[1], user[2]);
                order.add(new String[]{user[0], user[1]});
            } else {
                // 배열크기 3
                user = record[i].split(" ");
                map.put(user[1], user[2]);
            }
        }

        // 2. E와 L만 출력되므로 order를 기준으로 출력한다.
        answer = new String[order.size()];
        for (int i = 0 ; i < order.size() ; i++) {
            if ("Enter".equals(order.get(i)[0])) {
                answer[i] = map.get(order.get(i)[1]) + "님이 들어왔습니다.";
            } else {
                answer[i] = map.get(order.get(i)[1]) + "님이 나갔습니다.";
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
