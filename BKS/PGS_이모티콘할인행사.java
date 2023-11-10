package BKS;

import java.util.Arrays;

public class PGS_이모티콘할인행사 {
    static int[] discounts = {10, 20, 30, 40};
    static int maxSubscribe = 0;
    static int maxCost = 0;

    public static void main(String[] args) {
        int[] answer = new int[2];
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        // 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
        // 이모티콘 판매액을 최대한 늘리는 것.
        // 일정 할인율 이상이면 이모티콘 구매
        // 할인율 적용된 이모티콘 구매액이 최대금액 넘으면 플러스 구독
        findResult(0, new int[emoticons.length], users, emoticons);
        answer[0] = maxSubscribe;
        answer[1] = maxCost;
        System.out.println(Arrays.toString(answer));
    }

    public static void findResult(int idx, int[] discount, int[][] users, int[] emoticons) {
        if(idx == emoticons.length) { // 현재 이모티콘 개수에 대한 각 할인율 적용됐을 때
            int userSubscribe = 0; // 현재 턴에서 사용자들의 구독 수
            int userCost = 0; // 현재 턴에서 사용자들의 이모티콘 구매액

            // 모든 사용자들에 대한 구독자 및 구매액 구하기
            for(int[] user : users) {
                int userDiscountRate = user[0];
                int userPurchaseCost = user[1];
                int totalPurchase = 0;

                for(int i = 0 ; i < emoticons.length ; i++) {
                    if(discount[i] >= userDiscountRate) { // 현재 할인율이 사용자 정의 할인율 보다 크면 구매
                        totalPurchase += (emoticons[i] * (100 - discount[i])) / 100;
                    }
                }

                // 현재 이모티콘 구매액이 사용자정의 구매액보다 같거나 크면 플러스 구독
                if (totalPurchase >= userPurchaseCost) { // 크거나 같으면 플러스 구독
                    userSubscribe++;
                } else { // 작으면 그때의 구매액
                    userCost += totalPurchase;
                }
            }

            if (maxSubscribe < userSubscribe) {  // 플러스 구독이 우선순위가 높으므로 구독자, 구매액 갱신
                maxSubscribe = userSubscribe;
                maxCost = userCost;
            } else if (maxSubscribe == userSubscribe) { // 플러스 구독 없으므로 구매액 큰 값으로 갱신
                maxCost = Math.max(maxCost, userCost);
            }
            return;
        }

        for(int i = 0 ; i < discounts.length ; i++) {
            discount[idx] = discounts[i];
            findResult(idx + 1, discount, users, emoticons);
        }
    }
}
