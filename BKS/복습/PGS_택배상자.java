package BKS.복습;

import java.util.Stack;

public class PGS_택배상자 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        // 보조컨테이너 : 스택 LIFO

        // 1. 컨테이너 벨트 확인
        int idx = 0;
        for (int i = 1 ; i <= order.length ; i++) {
            if (order[idx] == i) {
                answer++;
                idx++;
            } else {
                stack.push(i); // 보조컨테이너에 넣기
            }

            // 2. 보조컨테이너 벨트 확인
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                answer++;
                idx++;
            }

        }
        System.out.println(answer);
    }
}
