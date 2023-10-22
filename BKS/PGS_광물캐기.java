package BKS;

import java.util.Arrays;
import java.util.Comparator;

public class PGS_광물캐기 {
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int answer = 0;
        int [][] section = new int[(minerals.length / 5) + 1][3]; // 섹션(광물 5개씩)별로 각 곡괭이로의 피로도 배열
        int cnt = picks[0] + picks[1] + picks[2]; // cnt(곡괭이 개수)

        // 다이아몬드, 철, 돌 곡괭이 0~5개 까지 소유, 광물 5번까지 캘 수 있음
        // picks : 곡괭이 개수 배열(곡괭이 다 쓰거나 광물이 없으면 끝)
        // minerals : 광물의 순서 배열(좋은 광물부터 내림차순 정렬)
        // 곡괭이를 들면 무조건 5번 캐야된다?
        //  -> 한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.

        // 섹션에 모든 피로도 계산 및 cnt(곡괭이 개수) 다 쓸 때 마다 -1
        for(int i = 0 ; i < minerals.length && cnt > 0; i++){
            if (minerals[i].equals("diamond")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 5;
                section[i / 5][2] += 25;
            } else if (minerals[i].equals("iron")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 5;
            } else {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 1;
            }
            if(i % 5 == 4) cnt--;
        }

        // 섹션에 대해 가장 적은 피로도로 오름차순 정렬(이후에 그리디에 사용되므로)
        Arrays.sort(section, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] < o2[2])
                    return 1;
                else
                    return -1;
            }
        });

        // 각 섹션별로 가장 적은 피로도를 answer에 담는다 (그리디)
        // 현재 pick이 없는 곡괭이라면 그 다음 곡괭이를 골라야 하므로 pick++
        int pick = 0;
        for(int i = 0 ; i < section.length ; i++){
            while(pick < 3 && picks[pick] == 0) {
                pick++;
            }
            // 곡괭이롤 모두 사용한 경우 while문에 의해 pick == 3이 되고 이때 반복문 탈출
            if(pick == 3) break;

            picks[pick]--; // 사용한 곡괭이 수는 -1 해주기
            answer += section[i][pick]; // 가장 적은 피로도 넣기
        }

        System.out.println(answer);
    }
}
