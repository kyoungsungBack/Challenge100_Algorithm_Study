package BKS;

import java.util.Arrays;

public class PGS_섬연결하기 {
    // 20240717 22:28 ~ 22:47
    public static int[] parent;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        // 크루스칼 -> 최소의 비용으로 최단거리를 찾는 그리디 방식

        int answer = 0;
        parent = new int[n];
        for (int i = 0 ; i < n ; i++) {
            parent[i] = i;
        }

        // 1. 비용 기준으로 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        // 2. 현재 두 노드의 부모가 다르면 합친다.
        //  -> 또한, 연결된 비용을 더한다. 최소신장트리가 완성되면 더이상 비용이 더해지지 않음
        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }

        System.out.println(answer);
    }
    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[bRoot] = aRoot;
        }
    }
}
