package BKS;

import java.util.Stack;

public class PGS_크레인인형뽑기게임 {
    // 20231215 22:50 ~ 23:31
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        for (int i : moves) {
            for (int j = 0 ; j < board.length ; j++) {
                if (board[j][i - 1] != 0) {
                    if (board[j][i - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][i - 1]);
                    }

                    board[j][i - 1] = 0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
