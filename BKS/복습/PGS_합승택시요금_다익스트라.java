package BKS.복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PGS_합승택시요금_다익스트라 {
    // 20240907 17:05 ~ 17:33
    static ArrayList<Taxi>[] list;
    public static void main(String[] args) {
        int answer = 20000001;
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        // 1. 인접리스트 정보를 세팅한다.
        list = new ArrayList[n + 1];

        for (int i = 0 ; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int weight = fare[2];

            list[start].add(new Taxi(end, weight));
            list[end].add(new Taxi(start, weight));
        }

        int[] sDistance = sol(n, s);

        for (int i = 1 ; i < sDistance.length ; i++) {
            int[] aDistance = sol(n, i);
            answer = Math.min(answer, sDistance[i] + aDistance[a] + aDistance[b]);
        }

        System.out.println(answer);
    }
    public static int[] sol(int n, int start) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, 20000001);

        PriorityQueue<Taxi> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Taxi(start, 0));

        while(!pq.isEmpty()) {
            Taxi cur = pq.poll();

            if (cur.weight > distance[cur.node]) {
                continue;
            }

            for (Taxi next : list[cur.node]) {
                if (distance[next.node] > distance[cur.node] + next.weight) {
                    distance[next.node] = distance[cur.node] + next.weight;
                    pq.offer(new Taxi(next.node, distance[next.node]));
                }
            }
        }

        return distance;
    }
}
class Taxi implements Comparable<Taxi> {
    int node;
    int weight;

    public Taxi(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Taxi o) {
        return this.weight - o.weight;
    }
}
