package BKS;

import java.util.HashMap;

public class PGS_전화번호목록 {
    // 20240417 17:42 ~ 19:08 (다시 풀기)
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], i);

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
