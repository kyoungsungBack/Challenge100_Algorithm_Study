package BKS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PGS_보석쇼핑 {
    // 20240507 21:20 ~ 21:50
    // 20240509 22:08 ~ 22:50
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = new int[2];
        // 시작과 끝 범위 내에서 모든 보석을 하나 이상 갖으며 가장 짧은 구간을 찾는다.
        // 1. 일단 map을 통해 모든 보석을 구한다.
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (String gem : gems) {
            set.add(gem);
        }

        int cnt = 0;
        int start = 0;
        int end = 0;
        // 2. 보석을 하나씩 담는다.
        //    이때, cnt가 map 크기보다 작을 때만 돈다.
        while (start <= end) {
            if (map.size() < set.size()) {
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;
            } else if (map.size() == set.size()) {
                // 그냥 제거해도 되는 경우가 존재?
                if (map.get(gems[start]) - 1 == 0) {
                    break;
                } else {
                    map.put(gems[start], map.get(gems[start]) - 1);
                    start++;
                }
            }
        }

        answer[0] = start + 1;
        answer[1] = end;

        System.out.println(Arrays.toString(answer));
    }
}
