package BKS;

import java.util.ArrayList;
import java.util.Collections;

public class COS_4차1급문제8 {
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        int card[] = {1, 2, 1, 3};
        int n = 1312;
        int answer = -1;
        int len = card.length;
        int[] cardSet = new int[10];
        int[] cardCur = new int[10];
        list = new ArrayList<>();

        for (int i = 0; i < card.length; i++) {
            cardSet[card[i]]++;
        }
        setting(0, "", cardCur, cardSet, len);
        Collections.sort(list);

        if (list.indexOf(n) >= 0) {
            answer = list.indexOf(n) + 1;
        }

        System.out.println(answer);
    }

    static void setting(int n, String str, int[] cardCur, int[] cardSet, int len) {
        if (n == len) {
            list.add(Integer.parseInt(str));
            return;
        }

        for (int i = 1; i < cardSet.length; i++) {
            if (cardCur[i] < cardSet[i]) {
                cardCur[i]++;
                setting(n + 1, str + String.valueOf(i), cardCur, cardSet, len);
                cardCur[i]--;
            }
        }
    }
}
