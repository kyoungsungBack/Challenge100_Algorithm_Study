package BKS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PGS_시소짝꿍 {
    public static void main(String[] args) {
        long answer = 0;
        int[] weights = {100, 180, 360, 100, 270};
        // 1. 큰 수 중에 만들 수 있는 작은 수를 찾기 위해 오름차순 정렬한다.
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        for (int w : weights) {
            // 2. 정렬된 수를 하나씩 뽑으며 이전의 작은 값을 만들 수 있는 경우를 찾는다.
            double a = w * 1.0;
            double b = (w * 2.0) / 3.0;
            double c = (w * 1.0) / 2.0;
            double d = (w * 3.0) / 4.0;

            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);
            if (map.containsKey(d)) answer += map.get(d);

            // 3. map에 작은 수를 하나씩 담는다.
            //    이때, 동일한 숫자가 존재하고 동일하면 기존 개수에 1을 추가한다.
            map.put((w * 1.0), map.getOrDefault((w * 1.0), 0) + 1);
        }
        System.out.println(answer);
    }
}
