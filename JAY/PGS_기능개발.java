package JAY;

import java.util.*;

public class PGS_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arr= new ArrayList<>();
        Queue<Integer> pro =new LinkedList<> ();
        Queue<Integer> spd =new LinkedList<> ();

        int day=1;
        int num=0;

        for(int i=0;i<progresses.length;i++){
            pro.add(progresses[i]);
        }

        for(int i=0;i<progresses.length;i++){
            spd.add(speeds[i]);
        }

        while(!pro.isEmpty()){
            int count=0;
            while(pro.peek()+(spd.peek()*day)<100)
                day++;
            while(!pro.isEmpty()&&pro.peek()+(spd.peek()*day)>=100){
                pro.remove();
                spd.remove();
                count++;
            }
            if(count>0)
                arr.add(count);
        }

        answer=new int[arr.size()];

        for(int i=0;i<arr.size();i++)
            answer[i]=arr.get(i);

        return answer;
    }
}
