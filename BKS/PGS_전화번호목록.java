package BKS;

import java.util.HashMap;

public class PGS_전화번호목록 {
    // 20240417 17:42 ~ 19:08 (다시 풀기)
    // 20240418 19:42 ~ 20:04
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();

        // 1. map에 phone_book 요소를 담는다.
        for (int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], i);

        // 2. map에서 각 phone_book요소의 접두사를 찾는다.
        for (int i = 0 ; i < phone_book.length ; i++) {
            // 3. map에 있는 값들에서 각 전화번호부의 접두사가 있는지 확인한다.
            //    이때, 마지막 한글자 전까지 확인하며 본인과 같은 경우를 방지한다.
            for (int j = 1 ; j < phone_book[i].length() ; j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
