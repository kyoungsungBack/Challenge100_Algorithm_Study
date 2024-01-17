package BKS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SFT_택배마스터광우 {
    // 20240117 10:14 ~ 50 11:00 ~ 11:16
    static int N, M;
    static int K;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;
        sol(0, new int[N], new boolean[N]);
        System.out.println(answer);
    }
    public static void sol(int idx, int[] order, boolean[] visited) {
        // 2. 탐색이 완료된 배열로 만들 수 있는 최솟값을 구한다.
        if (idx == N) {
            answer = Math.min(answer, weightSum(order));
            return;
        }

        // 1. 주어진 수 배열의 모든 순서를 탐색한다.
        for (int i = 0 ; i < N ; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                order[idx] = arr[i];
                idx++;
                sol(idx, order, visited);
                idx--;
                visited[i] = false;
            }
        }
    }

    public static int weightSum(int[] order) {
        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;
        int sum = 0;
        int total = 0;
        // 1. order에 있는 순서를 que에 담는다.
        for (int i = 0 ; i < order.length ; i++) {
            que.offer(order[i]);
        }

        // 2. que에 담긴 순서대로 무게를 확인한다.
        while (!que.isEmpty()) {
            int cur = que.poll();

            if (sum + cur <= M) {
                sum += cur;
            } else {
                total += sum;
                sum = cur;
                cnt++;
            }

            if (cnt == K) {
                break;
            }
            que.offer(cur);
        }
        return total;
    }
}
