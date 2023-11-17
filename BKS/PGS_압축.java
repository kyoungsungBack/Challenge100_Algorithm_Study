package BKS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PGS_압축 {
    public static void main(String[] args) {
        String msg = "KAKAO";
        int[] answer = {};
        Map<String, Integer> lzw = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // 1. 길이 1인 단어 사전등록
        int value = 1;
        for (char i = 'A' ; i <= 'Z' ; i++) {
            lzw.put(String.valueOf((char)i), value++); // 색인은 순차적으로 증가
        }

        // 2. 사전에서 msg의 마지막 문자까지 key의 등록과 찾는 과정 반복
        int idx = 0;
        while (idx < msg.length()) {
            String w = "";
            // 3. 사전에 등록안되어 있으면 반복문 탈출하여 사전에 등록한다
            while (idx < msg.length()) {
                if (!lzw.containsKey(w + msg.charAt(idx))) { // 사전에 등록 O
                    break;
                } else { // 사전에 등록 X
                    w += msg.charAt(idx); // 사전에 등록여부를 위해 다음글자 합침
                }
                idx++; // 3.1 msg의 키를 만들어주기 위해 한글자씩 더해야 하므로 idx 증가시켜준다.
            }

            ans.add(lzw.get(w)); // 4. 해당 문자의 색인 번호 출력

            if (idx < msg.length()) {
                lzw.put(w + msg.charAt(idx), value++); // 5. 최종으로 새로운 key 등록한다.
            }
        }

        answer = new int[ans.size()];
        for (int i = 0 ; i < ans.size() ; i++) {
            answer[i] = ans.get(i);
        }

        System.out.println(answer);
    }
}
