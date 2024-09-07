package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PGS_배달_다익스트라 {
    // 20240907 16:11 ~ 16:36
    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1,2,1}, {2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        int answer = 0;

        // 0. 최단거리 배열을 만든다.
        int[] distance = new int[N + 1];
        Arrays.fill(distance, 20000001); // 간선수 * 가중치

        // 1. 간선정보는 인접리스트에 저장한다.
        ArrayList<Node>[] list = new ArrayList[N + 1];

        for (int i = 0 ; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] arr : road) {
            int start = arr[0];
            int end = arr[1];
            int weight = arr[2];

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        distance[1] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            // 현재 점까지 온 거리가 최단거리 배열의 값보다 크면 무시한다.
            if (cur.weight > distance[cur.node] ) {
                continue;
            }

            // 현재 점과 연결된 점으로 이동하며 최단거리를 갱신한다.
            for (Node next : list[cur.node]) {
                // 연결된 점의 최단거리와 현재점의 최단거리 + 연결점으로 이동하는 가중치를 비교한다.
                if (distance[next.node] > distance[cur.node] + next.weight) {
                    distance[next.node] = distance[cur.node] + next.weight;
                    pq.offer(new Node(next.node, distance[next.node]));
                }
            }
        }

        for (int i = 1 ; i < distance.length ; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        System.out.println(answer);
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