package BKS;

public class COS_1차1급문제3 {
    public static void main(String[] args) {
        String pos = "A7";
        // Write code here.
        int[] mx = {-1, -2, 1, 2, -1, -2, 1, 2};
        int[] my = {2, 1, 2, 1, -2, -1, -2, -1};

        int[][] map = new int[8][8];
        int answer = 0;

        // 현재좌표
        int x = pos.charAt(0) - 'A';
        int y = pos.charAt(1) - '1';

        for (int i = 0; i < 8; i++) {
            int px = x + mx[i];
            int py = y + my[i];

            if (0 <= px && px < 8 && 0 <= py && py < 8) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
