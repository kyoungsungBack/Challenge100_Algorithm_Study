package BKS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PGS_주차요금계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        Map<String, Integer> map = new HashMap<>(); // key: 차량번호, value: 이용시간

        for(int i = 0 ; i < records.length ; i++){ // 입차
            int inTime = (Integer.parseInt(records[i].substring(0, 2)) * 60) + Integer.parseInt(records[i].substring(3, 5)); // 시간
            String inNum = records[i].substring(6, 10); // 차번호
            String inOrOut = records[i].substring(11, 12); // 입출차

            inTime = inOrOut.equals("I") ? inTime * -1 : inTime;
            int sum = map.get(inNum) == null ? 0 : map.get(inNum);
            map.put(inNum, sum + inTime); // 누적시간
        }

        int[] answer = new int[map.size()];
        int idx = 0;

        ArrayList<String> k = new ArrayList<>(map.keySet());
        Collections.sort(k);

        for(String key : k) {
            if(map.get(key) <= 0) { // 0 또는 음수: 입차만 있는 경우
                int num = 23 * 60 + 59;
                map.put(key, map.get(key) + num);
            }
        }

        // 주차요금 계산
        for (String key : k) {
            int cost = map.get(key);
            if (cost <= fees[0]) {
                answer[idx] = fees[1];
                idx++;
            } else {
                answer[idx] = (int)Math.ceil((cost - (double)fees[0]) / fees[2]) * fees[3] + fees[1];
                idx++;
            }
        }
    }
}
