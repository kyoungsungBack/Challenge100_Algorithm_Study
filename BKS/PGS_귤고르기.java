package BKS;

import java.util.*;

public class PGS_귤고르기 {
    // 20240404 13:52 ~ 14:37
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // 1. map에는 귤 무게에 대한 개수를 함께 담는다.
        for (int weight : tangerine) {
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }

        // 2. 귤의 무게와 개수를 list에 담는다.
        for (int key : map.keySet()) {
            list.add(new int[]{key, map.get(key)});
        }

        // 3. 귤 개수가 많은 순서로 내림차순 정렬
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int count = 0;
        // 4. k만큼 담을 수 있는 과일을 담는다.
        for (int i = 0 ; i < list.size() ; i++) {
            // 4.1. 더 담을 수 있으면 담고 카운트 증가한다.
            if (k > count + list.get(i)[1]) {
                count += list.get(i)[1];
                answer++;
            } // 4.2. 넘치거나 같으면 개수만 증가하고 반복문 종료한다.
            else {
                answer++;
                break;
            }
        }
        System.out.println(answer);
    }
}
