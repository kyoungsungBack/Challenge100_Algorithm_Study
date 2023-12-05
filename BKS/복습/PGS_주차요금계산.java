package BKS.복습;

import java.util.*;

public class PGS_주차요금계산 {
    public static void main(String[] args) {
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] fees = {180, 5000, 10, 600};

        int[] answer;
        Map<Integer, Integer> record = new HashMap<>();
        ArrayList<Integer> list;

        // 누적시간 초기 세팅
        for (int i = 0 ; i < records.length ; i++) {
            int hh = Integer.parseInt(records[i].substring(0, 2));
            int mm = Integer.parseInt(records[i].substring(3, 5));
            int number = Integer.parseInt(records[i].substring(6, 10));
            String inout = records[i].substring(11);

            if (record.get(number) == null) {
                record.put(number,  (-1)*((hh*60) + mm));
            } else {
                if (inout.equals("IN")) {
                    record.put(number, record.get(number) + (-1)*((hh*60) + mm));
                } else {
                    record.put(number, record.get(number) + (hh*60) + mm);
                }
            }
        }

        list = new ArrayList<>(record.keySet());
        Collections.sort(list);
        answer = new int[list.size()];

        // 누적시간 양수로 변환(입차만 존재할 때)
        for (int key : list) {
            if (record.get(key) <= 0) { // 음수
                record.put(key, record.get(key) + (23*60) + 59);
            }
        }

        // 금액 계산
        for (int i = 0 ; i < list.size() ; i++) {
            int key = list.get(i);

            if (record.get(key) <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = (int)Math.ceil((record.get(key) - fees[0]) / (double)fees[2]) * fees[3] + fees[1];
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
