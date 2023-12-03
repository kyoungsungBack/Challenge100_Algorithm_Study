package BKS.복습;

import java.util.Arrays;
import java.util.Stack;

public class PGS_뒤에있는큰수찾기 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        // 초기값은 -1이고 뒷큰수가 존재하면 stack의 값을 할당한다.
        for (int i = numbers.length - 1; i >= 0; i--) {
            answer[i] = -1;

            // 뒤에 있으면서 가장 가까운 큰 수를 stack에서 찾는다.
            // 현재 인덱스의 뒷큰수일 경우 break문으로 stack에 남겨둔다.
            while (!stack.isEmpty()) {
                int cur = stack.peek();
                if (numbers[i] >= cur) {
                    stack.pop();
                } else {
                    answer[i] = cur;
                    break;
                }
            }
            stack.push(numbers[i]);
        }


        System.out.println(Arrays.toString(answer));
    }
}

