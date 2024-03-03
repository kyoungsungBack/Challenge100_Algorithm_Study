package BKS.복습;

import java.util.ArrayList;
import java.util.Collections;

public class PGS_모음사전 {
    // 20240303 16:49 ~ 16:58
    static ArrayList<String> list;
    static String[] strArr = {"A", "E", "I", "O", "U"};
    public static void main(String[] args) {
        String word = "AAAAE";
        int answer = 0;
        // 0. ArrayList에 AEIOU로만 이뤄진 단어를 등록한다.
        list = new ArrayList<>();

        // 1. dfs를 통해 AEIOU를 통해 만들 수 있는 단어를 만들어 등록한다.
        sol("");
        // 5. 단어를 정렬한다.
        Collections.sort(list);

        // 6. 주어진 word의 순서를 사전에서 찾아 반환한다.
        System.out.println(list.indexOf(word));
    }

    public static void sol(String str) {
        // 2. 사전에 단어를 등록한다.
        list.add(str);

        // 3. 만약 단어의 길이가 5 이면 종료한다.
        if (str.length() == 5) {
            return;
        }

        // 4. 단어의 길이가 5 미만이면 AEIOU중 한 단어를 합쳐서
        //    재귀호출 하여 다음 사전에 등록한다.
        for (int i = 0 ; i < 5 ; i++) {
            sol(str + strArr[i]);
        }
    }
}
