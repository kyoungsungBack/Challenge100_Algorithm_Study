package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PGS_배달_다익스트라 {
    static ArrayList<Node>[] list;
    static int[] distance;
    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1,2,1}, {2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        int answer = 0;

        // 0. 최단거리 배열을 만든다.
        distance = new int[N + 1];
        Arrays.fill(distance, 20000001);

        // 1. 간선정보는 인접리스트에 저장한다.
        list = new ArrayList[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] arr : road) {
            int start = arr[0];
            int end = arr[1];
            int value = arr[2];

            list[start].add(new Node(end, value));
            list[end].add(new Node(start, value));
        }

        dijkstra(1);

        for (int i = 1 ; i <= N ; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        System.out.println(answer);
    }
    public static void dijkstra(int start) {
        // 각 노드의 가중치 기준 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (pq.isEmpty() != true) {
            Node cur = pq.poll();

            // 현재 노드 까지의 최단거리와 최단거리 배열의 값을 비교
            // 이때, 현재 배열에 저장된 가중치가 더 적으면 무시한다.
            if (cur.weight > distance[cur.node]) {
                continue;
            }

            for (Node next : list[cur.node]) {
                // 연결된 점을 이동했을 때 더 최단거리이면 갱신한다.
                if (distance[next.node] > distance[cur.node] + next.weight) {
                    distance[next.node] = distance[cur.node] + next.weight;

                    pq.offer(new Node(next.node, distance[next.node]));
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int node;
    int weight;

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    // weigth 기준 오름차순
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}