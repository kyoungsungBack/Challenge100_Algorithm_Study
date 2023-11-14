package BKS;

import java.util.*;

public class PGS_롤케이크자르기 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int answer = 0;

        // 크기와 상관없이 토핑 가지 수만 같으면 답
        // 반복문에서 토핑 배열은 순서대로 하나씩 확인
        Map<Integer, Integer> orderBro = new HashMap<>();
        Set<Integer> youngBro = new HashSet<>();

        for (int i : topping) {
            if (orderBro.get(i) != null) {
                orderBro.put(i, orderBro.get(i) + 1);
            } else {
                orderBro.put(i, 1);
            }
        }

        for (int i : topping) {
            orderBro.put(i, orderBro.get(i) - 1);
            youngBro.add(i);

            if (orderBro.get(i) == 0) {
                orderBro.remove(i);
            }

            if (orderBro.size() == youngBro.size()) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
