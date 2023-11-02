package BKS;

import java.util.Arrays;

public class PGS_이모티콘할인행사 {
    static int[] discount = {10, 20, 30, 40};
    static int maxOfSubscribe;
    static int maxOfCost;

    public static void main(String[] args) {
        int[] answer = new int[2];
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        // 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
        // 2. 이모티콘 판매액을 최대한 늘리는 것.
        // 할인율은 10%, 20%, 30%, 40% -> 할인율 배열 {10, 20, 30, 40}
        findResult(0,emoticons.length, new int[emoticons.length],users,emoticons);
        answer[0] = maxOfSubscribe;
        answer[1] = maxOfCost;
        System.out.println(Arrays.toString(answer));
    }

    public static void findResult(int index,int emoticonsLength, int[] discounts,int[][] users, int[] emoticons){
        // 모든 할인율에 대해서 계산을 한다.
        if (index == emoticonsLength) {
            int subscribe = 0; // 플러스 구독 수
            int cost = 0; // 이모티콘 구매액

            for (int[] user: users){
                int userDiscountRate = user[0]; // 현재 고객의 이모티콘 구매 조건 할인율
                int userMaxCost = user[1]; // 현재 고객의 플러스 구독에 필요한 최소금액

                int sum = 0; // 고객마다 할인된 이모티콘 구매액

                for (int i = 0; i < emoticons.length; i++){
                    if (discounts[i] >= userDiscountRate){
                        sum += (emoticons[i] / 100) * (100 - discounts[i]);
                    }
                }

                if (sum >= userMaxCost) subscribe++; // 할인된 이모티콘 구매액이 플러스 구독에 필요한 최소금액 크면 구독
                else cost+=sum; // 아니면, 이모티콘 구매
            }

            if (subscribe > maxOfSubscribe) { // 구독자가 발생하면 구독자 수와 구매액 할당
                maxOfSubscribe = subscribe;
                maxOfCost = cost;
            } else if (subscribe == maxOfSubscribe) { // 구독자가 같으면 현재 구매액만 할당
                maxOfCost = Math.max(maxOfCost,cost);
            }
            // 이때, subscribe < maxOfSubscribe 를 작성하지 않으면서 구독자와 구매액이 작은 경우를 무시하게 된다.

            // 최종적으로 최대 구독자 수와 최대 구매액을 찾게 된다.
            return;
        }

        // 재귀를 통해 각 이모티콘들에 대한 경우의 수를 구한다.
        //  (최대 4^7: 4는 할인율 개수, 7는 이모티콘 최대 개수)
        //    재귀호출이 아닐 시에 최대 4중 반복을 돌려야 한다.
        for (int i = 0; i < 4; i++){
            discounts[index] = discount[i];
            findResult(index+1,emoticonsLength,discounts,users,emoticons);
        }
    }
}
