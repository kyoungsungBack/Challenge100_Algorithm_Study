package BKS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PGS_시소짝꿍 {
    // 20240402 19:10 ~ 19:35 (복습)
    // 20240403 18:53 ~ 19:06 (복습)
    public static void main(String[] args) {
        long answer = 0;
        int[] weights = {100, 180, 360, 100, 270};
        // 0. 어쨌든 같은 거리에 있는 것만 확인되면 쌍으로 인정된다.

        // 1. weights을 오름차순으로 정렬하여 작은 수들과 같은 값이 되는지 확인한다.
        Arrays.sort(weights);

        // 2. 나누었을 때 소수가 될 수 있으므로 Double, Integer 타입으로 선언한다.
        Map<Double, Integer> map = new HashMap<>();

        for (int w : weights) {
            // 3. 큰 수가 작아질 수 있는 경우를 모두 확인한다.
            double a = w * 1.0;
            double b = (w * 2.0) / 3.0;
            double c = (w * 1.0) / 2.0;
            double d = (w * 3.0) / 4.0;

            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);
            if (map.containsKey(d)) answer += map.get(d);

            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        System.out.println(answer);
    }
}
