package BKS;

import java.util.HashMap;
import java.util.HashSet;

public class PGS_할인행사 {
    // 20241001 16:47 ~ 18:30
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int answer = 0;

        HashMap<String, Integer> mart = new HashMap<>();
        HashSet<String> martName = new HashSet<>();
        for (int i = 0 ; i < discount.length ; i++) {
            martName.add(discount[i]);
        }

        for (String str : martName) {
            mart.put(str, 0);
        }

        // 1. 매장의 10일치 개수를 센다.
        // discount.length(14) - 10
        for (int i = 0 ; i < 10 ; i++) {
            mart.put(discount[i], mart.get(discount[i]) + 1);
        }

        HashMap<String, Integer> items = new HashMap<>();
        for (int i = 0 ; i < want.length ; i++) {
            items.put(want[i], number[i]);
        }


        // 2. 확인해볼 일 수
        for (int i = 0 ; i <= discount.length - 10 ; i++) {
            boolean isOkay = true; // 현재 수량이 마트 수량과 같은지 확인

            for (String item : items.keySet()) {
                if (items.get(item) != mart.get(item)) {
                    isOkay = false;
                    break;
                }
            }

            if (isOkay) {
                answer++;
            }

            if (i + 10 < discount.length) {
                mart.put(discount[i], mart.get(discount[i]) - 1);
                mart.put(discount[i + 10], mart.get(discount[i + 10]) + 1);
            }

        }
        System.out.println(answer);
    }
}
