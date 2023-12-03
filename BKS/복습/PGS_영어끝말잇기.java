package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;

public class PGS_영어끝말잇기 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] answer = {0, 0};
        ArrayList<String> list = new ArrayList<>();
        // 번호(answer[0]) : (i % n) + 1
        // 차례(answer[1]) : (i / n) + 1

        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String previous = words[i - 1];
            String cur = words[i];
            if (list.indexOf(cur) > -1 || previous.charAt(previous.length() - 1) != cur.charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            } else {
                list.add(words[i]);
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
