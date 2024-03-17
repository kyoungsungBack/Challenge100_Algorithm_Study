package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PGS_오픈채팅방 {
    // 20240313 19:38 ~ 20:11
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        HashMap<String, String> dic = new HashMap<>(); // 유저아이디, 닉네임
        ArrayList<String[]> list = new ArrayList<>(); // 유저아이디, 행동

        // 1. record에 대해 데이터를 저장한다.
        for (int i = 0 ; i < record.length ; i++) {
            String[] str = record[i].split(" ");

            // 1.1. 사용자가 떠났을 때
            if ("Leave".equals(str[0])) {
                list.add(new String[]{str[1], "님이 나갔습니다."});
            } else {
                // 1.2. 사용자가 들어왔을 때
                if ("Enter".equals(str[0])) {
                    dic.put(str[1], str[2]);
                    list.add(new String[]{str[1], "님이 들어왔습니다."});
                } // 1.3. 사용자가 이름을 바꿨을 때
                else {
                    dic.put(str[1], str[2]);
                }
            }
        }

        // 2. list에 담긴 순서대로 출력한다.
        String[] answer = new String[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            answer[i] = dic.get(list.get(i)[0]) + list.get(i)[1];
        }

        System.out.println(Arrays.toString(answer));
    }
}
