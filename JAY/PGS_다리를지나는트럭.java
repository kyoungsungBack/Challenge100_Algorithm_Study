package JAY;

import java.util.*;

public class PGS_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        int sum=0;

        for(int i=0;i<truck_weights.length;i++){
            int w = truck_weights[i];

            while(true){
                if(que.isEmpty()){
                    que.add(w);
                    sum+=w;
                    answer++;
                    break;
                }else if(que.size()==bridge_length){
                    sum-=que.poll();
                }else{
                    if(sum+w<=weight){
                        que.add(w);
                        sum+=w;
                        answer++;
                        break;
                    }else{
                        que.add(0);
                        answer++;
                    }
                }
            }
        }

        return answer+bridge_length;
    }
}
