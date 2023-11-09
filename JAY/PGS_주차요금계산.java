package JAY;

import java.util.*;

public class PGS_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Integer> map = new TreeMap<>();

        for(int i=0;i<records.length;i++){
            String[] recordArr = records[i].split(" ");
            String[] timeArr = recordArr[0].split(":");

            int time = (recordArr[2].equals("IN")?-1:1)*((Integer.parseInt(timeArr[0]) * 60) + Integer.parseInt(timeArr[1]));
            String car = recordArr[1];

            map.put(car, map.getOrDefault(car,0)+time);
        }

        answer = new int[map.size()];

        int i=0;

        for(String key : map.keySet()){
            int time = map.get(key);
            if(time<=0){
                time=time+((23*60)+59);
            }

            double baseTime=0;

            if(time-fees[0]>=0){
                baseTime=time-fees[0];
            }
            int price = fees[1]+(int)Math.ceil(baseTime/fees[2])*fees[3];

            answer[i++]=price;
        }

        return answer;
    }
}
