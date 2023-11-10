package JSB;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class PGS_기능개발 {

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> date = new LinkedList<>();
            ArrayList<Integer> answerList = new ArrayList<>();

            //기능 별 개발 시간
            for(int i=0;i<progresses.length;i++){
                int sTime = (int)Math.ceil((100-progresses[i])/(double)speeds[i]) ;//올림 사용
                date.add(sTime);
            }
            int front = date.poll();//맨 앞 날짜 확인.
            int count =1;
            while(!date.isEmpty()){
                if(front < date.peek()){//앞 기능보다 뒷 기능이 늦게 구현될 겅우 추가
                    answerList.add(count);
                    count=1;        //새롭게 확인해야함으로 초기화
                    front = date.poll();
                }else{              //아닐떄
                    count++;
                    date.poll();
                }
            }
            answerList.add(count);      //마지막 카운트 추가

            int[] answer = new int[answerList.size()];

            for(int i=0;i<answer.length;i++){
                answer[i] = answerList.get(i);
            }
            return answer;
        }
    }
}
