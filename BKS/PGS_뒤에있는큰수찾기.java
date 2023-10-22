package BKS;

import java.util.Arrays;
import java.util.Stack;

public class PGS_뒤에있는큰수찾기 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        //int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] answer = new int[numbers.length];
        Stack<Integer> st = new Stack<>();

        // 현재 idx 뒤에서 뭔가를 작업해야 하면 뒤에 부터 작업을 해준다고 의심하기.
        // {5, 3, 3, 2} 일 때로 가정하고 자신보다 앞에 있으면서 큰 숫자를 찾는 문제로 변형
        // 아래 반복문에서 1~8의 과정을 반복해서 answer을 작성한다.

        for (int i = numbers.length - 1; i >= 0 ; i--) {
            answer[i] = -1; // 1
            int number = numbers[i]; // 2
            while(!st.isEmpty()){ // 4
                int top = st.peek();
                if(number < top){ // 5 크기비교
                    answer[i] = top;
                    break; // 6 앞의 숫자들도 현재 자신보다 작거나 같으면 top은 계속 쓰일 것 이므로 반복문 탈출
                }
                st.pop(); // 7 현재 자신보다 작으면 그 앞의 수에서는 현재 자신이 쓰일 것이므로 상단값 제외
            }
            st.push(number); // 3, 8 자신의 계속 쓰일 것이므로
        }

        // 완전탐색의 경우, 시간초과
        /*
        for(int i = 0 ; i < numbers.length ; i++){
            for(int j = i + 1 ; j < numbers.length ; j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j];
                    break;
                }
            }
        }
        */

        System.out.println(Arrays.toString(answer));
    }
}
