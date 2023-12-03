package BKS.복습;

import java.util.Arrays;
import java.util.Comparator;

public class PGS_광물캐기 {
    public static void main(String[] args) {
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int[] picks = {1, 3, 2};
        int answer = 0;
        int[][] section = new int[(minerals.length / 5) + 1][3];

        int pick = picks[0] + picks[1] + picks[2];
        // 광물과 곡괭이 개수가 만족할 만큼만 피로도 계산
        for (int i = 0; i < minerals.length && 0 < pick; i++) {
            if (minerals[i].equals("diamond")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 5;
                section[i / 5][2] += 25;
            } else if (minerals[i].equals("iron")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 5;
            } else if (minerals[i].equals("stone")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 1;
            }

            if (i % 5 == 4) {
                pick--;
            }
        }

        // 모든 섹션을 돌곡괭이 기준으로 내림차순 정렬
        Arrays.sort(section, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] < o2[2]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < section.length; i++) {
            if (picks[0] != 0) {
                answer += section[i][0];
                picks[0]--;
            } else if (picks[1] != 0) {
                answer += section[i][1];
                picks[1]--;
            } else if (picks[2] != 0) {
                answer += section[i][2];
                picks[2]--;
            }
        }
        System.out.println(answer);
    }
}
