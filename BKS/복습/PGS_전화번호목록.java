package BKS.복습;

import java.util.Arrays;
import java.util.HashMap;

public class PGS_전화번호목록 {
    // 20240418 19:42 ~ 20:04
    // 20240601 17:18 ~ 17:51
    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};
        boolean answer = true;
        // 어떤 번호가 다른 번호의 접두어인 경우 -> false
        // 그렇지 않으면 -> true

        // 현재 수에 대해 0부터 한자리씩 늘려가며 맵에 존재하면 false를 반환한다.
        HashMap<String, Boolean> map = new HashMap<>();

        // 1. 오름차순 정렬한다.
        Arrays.sort(phone_book);

        // 2. 배열의 수를 하나씩 빼서 접두어를 확인한다.
        for (String num : phone_book) {
            int len = num.length();

            // 2.1. 현재 수의 길이 만큼 접두어가 map에 존재 하는지 확인한다.
            for (int j = 1 ; j <= len ; j++) {
                // map.containsKey(num.substring(0, j)) 사용 가능
                if (map.get(num.substring(0, j)) == null) {
                    continue;
                } else if (map.get(num.substring(0, j))) {
                    //return false;
                    answer = false;
                    break;
                }
            }
            map.put(num, true);
        }
        System.out.println(answer);
    }
}
