package BKS;

import java.util.LinkedList;
import java.util.Queue;

public class COS_5차1급문제9 {
    public static void main(String[] args) {
        int number = 5;
        int target = 9;
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        int[] visited = new int[10001];
        que.offer(number);
        visited[number] = 0;
        // 연산을 최소 몇번해서 구할 수 있는지를 물어보므로 연산값을 인덱스로 갖는 배열이 0이어야 한다
        while (!que.isEmpty()) {
            int x = que.poll();

            if (x == target) {
                break;
            }

            if (x + 1 <= 10000 && visited[x + 1] == 0) {
                visited[x + 1] = visited[x] + 1;
                que.offer(x + 1);
            }

            if (x - 1 >= 0 && visited[x - 1] == 0) {
                visited[x - 1] = visited[x] + 1;
                que.offer(x - 1);
            }

            if (x * 2 <= 10000 && visited[x * 2] == 0) {
                visited[x * 2] = visited[x] + 1;
                que.offer(x * 2);
            }
        }

        System.out.println(visited[target]);
    }
}
