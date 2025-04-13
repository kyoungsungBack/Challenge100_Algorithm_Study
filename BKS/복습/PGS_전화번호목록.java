package BKS.복습;

import java.util.Arrays;
import java.util.HashMap;

public class PGS_전화번호목록 {
    // 20240418 19:42 ~ 20:04
    // 20240601 17:18 ~ 17:51
    // 20250413 17:39 ~ 17:49 (복습)
    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};
        boolean answer = true;
        HashMap<String, Boolean> mapPhoneBook = new HashMap<>();
        Arrays.sort(phone_book);

        for (String str : phone_book) {
            int len = str.length();
            for (int i=1 ; i <= len ; i++) {
                if (mapPhoneBook.get(str.substring(0,i))==null) {
                    continue;
                }
                else {
                    answer=false;
                    break;
                }
            }
            mapPhoneBook.put(str, true);
        }
        System.out.println(answer);
    }
}
