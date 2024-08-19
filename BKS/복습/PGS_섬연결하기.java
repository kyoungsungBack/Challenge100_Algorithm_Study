package BKS.복습;

import java.util.Arrays;

public class PGS_섬연결하기 {
    // 20240811 16:52 ~ 17:26
    static int[] parent;
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int answer = 0;

        // 0. 부모배열을 생성한다.
        parent = new int[n];

        // 1. 부모배열의 각 점은 본인으로 초기화 한다.(싸이클)
        for (int i = 0 ; i < n ; i++) {
            parent[i] = i;
        }

        // 2. 최소비용 기준 오름차순 으로 정렬한다.
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        // 3. 최소신장트리(MST)를 만든다.
        for (int i = 0 ; i < costs.length ; i++) {
            // 3.1. 연결된 노드를 연결하고 비용을 더 한다.
            //     -> 두 노드가 아직 연결되지 않았으면 연결한다.
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        System.out.println(answer);
    }
    // find 함수 -> 현재 노드의 부모를 반환한다.
    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    // union 함수 -> 두 노드를 연결한다.
    public static void union(int a, int b) {
        // 각 노드의 부모를 찾는다.
        int numA = find(a);
        int numB = find(b);

        // 각 노드의 부모가 같지 않으면 합친다.
        if (numA != numB) {
            parent[numB] = numA;
        }
    }
}
