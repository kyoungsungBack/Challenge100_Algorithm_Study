package BKS;

import java.util.Stack;

public class PGS_택배상자 {
    public static void main(String[] args) {
        int answer = 0;
        int[] order = {4, 3, 1, 2, 5};
        Stack<Integer> stack = new Stack<>(); // 보조 컨베이어 벨트

        int idx = 0; // 택배기사의 순서 index
        // 택배순서의 처음과 일치하는 수는 무조건 존재
        //  두 수가 같으면 그 다음 택배순서는 보조트레일러와도 비교해서 택배에 싣는다.
        //  두 수가 다르면 while문 조건만 확인한다.(어차피 아니게 됨)
        for (int i = 1 ; i <= order.length ; i++) {
            // 1. 먼저 컨베이어 벨트와 택배순서 비교
            if(order[idx] == i) { // 1-1. 같으면 택배순서 idx 증가, 트럭에 싣는다.
                idx++;
                answer++;
            } else { // 1-2. 다르면 보조 컨베이어에 삽입
                stack.push(i);
            }

            // 2. 보조 트레일러에 상자 존재하고 택배순서와 같으면 계속 트럭에 싣는다.
            while (!stack.isEmpty() && order[idx] == stack.peek()) {
                stack.pop();
                idx++;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
