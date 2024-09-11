package BKS;

import java.util.ArrayList;

public class PGS_줄서는방법 {
    // 20240908 12:14 ~ 12:42(시간, 메모리초과)
    // 20240909 21:33 ~ 21:53
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        long f = 1;
        for(int i = 1 ; i <= n ; i++) {
            list.add(i);
            f *= i;
        }

        // 2. 현재 배열에 수가 채워질 때 까지 자릿수를 계산한다.
        k--; // 2.1. 첫번째 자리 계산을 위해 1 줄여준다.(k, f가 배수관계일 경우 자릿수 오류)
        int idx = 0;

        while (idx < n) {
            f /= (n - idx); // 3. 몇개씩 묶음이 되는지 계산한다. 즉, (n - idx)는 현재 명을 의미한다.
            answer[idx++] = list.remove((int)(k / f));
            k %= f; // 4. 다음 계산에서 몇번째 자리가 필요한지를 의미
        }
        System.out.println(answer);
    }

    /* BFS(완전탐색) 풀이는 시간초과 발생 */
//    public static void sol(int n, int idx, int[] arr, boolean[] visited) {
//        // 줄서는 방식을 넣는다.
//        if (n == idx) {
//            list.add(arr);
//            return;
//        }
//
//        for (int i = 1 ; i <= n ; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                arr[idx] = i;
//                sol(n, idx + 1, arr.clone(), visited);
//                visited[i] = false;
//            }
//        }
//    }
}
