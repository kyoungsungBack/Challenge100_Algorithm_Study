package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PGS_압축 {
    // 20231210 17:03 ~ 18:04(해답풀이)
    public static void main(String[] args) {
        String msg = "KAKAO";
        int[] answer;
        ArrayList<Integer> ans = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        int num = 1;

        // 0. 26번까지 알파벳 등록
        for (char i = 'A' ; i <= 'Z' ; i++) {
            dic.put(String.valueOf(i), num++);
        }

        int idx = 0; // msg를 나타낼 index

        // 1. msg의 끝까지 확인하며 색인을 출력한다.
        while (idx < msg.length()) {
            String key = "";

            // 2. key의 등록여부 확인
            // 2.1. key가 등록이 안되어있으면 다음 문자까지 늘려간다.
            // 2.2. key가 등록이 된 경우 반복문 탈출
            while (idx < msg.length()) {
                if (!dic.containsKey(key + msg.charAt(idx))) {
                    break;
                } else {
                    key += msg.charAt(idx);
                    idx++;
                }
            }

            // 3. key의 색인을 추출한다.
            ans.add(dic.get(key));

            // 4. 현재 key의 다음문자열 까지 합하여 사전에 등록한다.
            if (idx < msg.length()) {
                dic.put(key + msg.charAt(idx), num++);
            }
        }

        answer = new int[ans.size()];
        for (int i = 0 ; i < ans.size() ; i++) {
            answer[i] = ans.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }
}
