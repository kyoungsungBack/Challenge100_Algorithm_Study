package BKS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PGS_시소짝꿍 {
    // 20240402 19:10 ~ 19:35 (복습)
    public static void main(String[] args) {
        long answer = 0;
        int[] weights = {100, 180, 360, 100, 270};
        // 1. weights의 작은 수 부터 Map에 담기 위해 정렬한다.
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        // 2. weights의 무게를 담고 2,3,4배로 줄일 수 있는 수를 탐색한다.
        for (int w : weights) {
            double a = w * 1.0; // 2.1. 원래 수를 담는다.
            double b = (w * 2.0) / 3; // 2.2.
            double c = (w * 1.0) / 2;
            double d = (w * 3.0) / 4;

            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);
            if (map.containsKey(d)) answer += map.get(d);

            // 3. weights의 하나씩 map에 등록하여 이후 숫자로 만들 수 있는지
            //    확일할 때 사용한다.
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        System.out.println(answer);
    }
}
