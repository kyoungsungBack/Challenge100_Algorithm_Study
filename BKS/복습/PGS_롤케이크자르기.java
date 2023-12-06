package BKS.복습;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PGS_롤케이크자르기 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int answer = 0;
        Map<Integer, Integer> oldBro = new HashMap<>();
        Set<Integer> youngBro = new HashSet<>();

        // 1. 토핑 세팅
        for (int i = 0 ; i < topping.length ; i++) {
            if (oldBro.get(topping[i]) == null) {
                oldBro.put(topping[i], 1);
            } else {
                oldBro.put(topping[i], oldBro.get(topping[i]) + 1);
            }
        }

        for (int key : topping) {
            oldBro.put(key, oldBro.get(key) - 1);
            youngBro.add(key);

            if (oldBro.get(key) == 0) {
                oldBro.remove(key);
            }

            if (oldBro.size() == youngBro.size()) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
