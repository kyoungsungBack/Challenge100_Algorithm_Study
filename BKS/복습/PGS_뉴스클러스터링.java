package BKS.복습;

import java.util.HashMap;
import java.util.Map;

public class PGS_뉴스클러스터링 {
    public static void main(String[] args) {
        //20231208 15:23 ~ 17:19
        String str1 = "FRANCE";
        String str2 = "french";
        int answer = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // 대문자로 변경
        String alpha = "[^A-Z]";
        str1 = str1.toUpperCase().replaceAll(alpha, " ");
        str2 = str2.toUpperCase().replaceAll(alpha, " ");

        // str1 개수 세팅
        for (int i = 2 ; i < str1.length() + 1; i++) {
            String key = str1.substring(i - 2, i);

            if (key.contains(" ")) {
                continue;
            }

            if (map1.get(key) == null) {
                map1.put(key, 1);
            } else {
                map1.put(key, map1.get(key) + 1);
            }
        }

        // str2 개수 세팅
        for (int i = 2 ; i < str2.length() + 1; i++) {
            String key = str2.substring(i - 2, i);

            if (key.contains(" ")) {
                continue;
            }

            if (map2.get(key) == null) {
                map2.put(key, 1);
            } else {
                map2.put(key, map2.get(key) + 1);
            }
        }
        int insertion = 0;
        int union = 0;

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                insertion += Math.min(map1.get(key), map2.get(key));
            }
        }

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                union += Math.max(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            }
        }

        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                union += map2.get(key);
            }
        }

        // 두 집합이 공집합일 때
        if (map1.size() == 0 && map2.size() == 0) {
            answer = 65536;
        } else {
            answer = (int)Math.floor((insertion / (double)union) * 65536);
        }

        System.out.println(answer);
    }
}
