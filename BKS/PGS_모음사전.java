package BKS;

import java.util.ArrayList;

public class PGS_모음사전 {
    // 20240114 10:38 ~ 10:55
    static ArrayList<String> list;
    static String words;
    public static void main(String[] args) {
        int answer = 0;
        String word = "AAAAE";
        words = "AEIOU";
        list = new ArrayList<>();

        sol(0, "", new boolean[5]);

        answer = list.indexOf(word);
        System.out.println(answer);
    }
    public static void sol(int len, String str, boolean[] visited) {

        // 1. 사전에 단어를 모두 등록한다.
        list.add(str);

        if (len == 5) {
            return;
        }

        // 2. 단어목록에서 방문하지 않은 단어를 추가하여 재귀호출 한다.
        for (int i = 0 ; i < 5 ; i++) {
            sol(len + 1, str + words.charAt(i), visited);
        }

    }
}
