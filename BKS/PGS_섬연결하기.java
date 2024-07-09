package BKS;

import java.util.Arrays;

public class PGS_섬연결하기 {
    public static int[] parent;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int answer = 0;
        parent = new int[n];
        for (int i = 0 ; i < n ; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

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
