package BKS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_최소스패닝트리 {
    // 20241001 15:26 ~ 16:05
    public static int V, E;
    public static int[][] map;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];

        // 각 정점의 루트는 자신으로 초기화
        for (int i = 1 ; i <= V ; i++) {
            parent[i] = i;
        }

        // 최소스패닝트리는 크루스칼 알고리즘 이용
        // 유니온 파인드, 우선순위 큐, 그리디
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0 ; i < E ; i++) {
            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int value = Integer.parseInt(info[2]);

            pq.offer(new int[]{start, end, value});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int start = cur[0];
            int end = cur[1];
            int value = cur[2];

            if (find(start) != find(end)) {
                union(start, end);
                answer += value;
            }
        }

        System.out.println(answer);
    }
    // 현재 정점의 루트를 반환하는 메서드
    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    // 두 정점을 합쳐주는 메서드(작은, 큰)
    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        // 서로의 부모가 다르면 작은수를 큰쪽의 부모로 업데이트 한다.
        if (aRoot != bRoot) {
            parent[bRoot] = aRoot;
        }
    }
}
