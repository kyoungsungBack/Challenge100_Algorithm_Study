package JAY;

import java.util.*;

class PGS_뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(answer,-1);
        
        for(int i=numbers.length-1;i>=0;i--){
            while(!stack.isEmpty()){
                if(stack.peek()>numbers[i]){
                    answer[i]=stack.peek();
                    break;
                }
                stack.pop();
            }

            stack.add(numbers[i]);
        }
        
        return answer;
    }
}

