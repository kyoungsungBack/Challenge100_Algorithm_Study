package BKS;

import java.util.*;

public class PGS_주차요금계산 {
    public static void main(String[] args) {
        //String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        //int[] fees = {180, 5000, 10, 600};
        //String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        //int[] fees = {120, 0, 60, 591};
        String[] records = {"00:00 1234 IN"};
        int[] fees = {1, 461, 1, 10};
        Map<String, Integer> map = new HashMap<>();
        // 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때
        // 차량별로 주차 요금을 계산
        // 00:00부터 23:59까지의 입/출차 내역
        // IN: 입차, OUT: 출차
        // 입차 -> 출차 순이고 출차를 해야 새로운 입차가 가능

        for(int i = 0 ; i < records.length ; i++){ // 입차
            int inTime = (Integer.parseInt(records[i].substring(0, 2)) * 60) + Integer.parseInt(records[i].substring(3, 5)); // 시간
            String inNum = records[i].substring(6, 10); // 차번호
            String inOrOut = records[i].substring(11, 12); // 입출차
            boolean isFirst = false; // 출차내역

            if (inOrOut.equals("O")) { // 출차이면 씹는다
                continue;
            }

            for(int j = i + 1 ; j < records.length ; j++){ // 출차
                int outTime = (Integer.parseInt(records[j].substring(0, 2)) * 60) + Integer.parseInt(records[j].substring(3, 5)); // 시간
                String outNum = records[j].substring(6, 10); // 차번호

                if (inNum.equals(outNum)) {
                    int num = outTime - inTime;
                    int sum = map.get(inNum) == null ? 0 : map.get(inNum);
                    map.put(inNum, sum + num); // 누적시간
                    isFirst = true;
                    break;
                }
            }

            if (isFirst == false) { // 출차내역 없으면 23:59로 계산
                int num = (23 * 60 + 59) - inTime;
                int sum = map.get(inNum) == null ? 0 : map.get(inNum);
                map.put(inNum, sum + num); // 누적시간
            }
        }

        int[] answer = new int[map.size()];
        int idx = 0;
        ArrayList<String> k = new ArrayList<>(map.keySet());
        Collections.sort(k);
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

        System.out.println(Arrays.toString(answer));
    }
}
