package BKS;

public class PGS_징검다리건너기 {
    // 20240113 18:18 ~ 18:28 (복습 해야 함)
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int answer = 0;
        // 0. 최대 몇 명이 징검다리를 건널 수 있는지 구한다.
        // -> 즉, 최적의 해를 구하므로 이분탐색으로 접근한다.
        int low = 1;
        int high = 200000000;
        int mid = 0;

        // 1. mid는 다리를 건널 수 있는 사람의 수이다.
        while (low <= high) {
            mid = (low + high) / 2;
            // 2.1 건널 수 있는 경우 low 증가하여 최대값을 찾는다.
            if (isTrue(stones, mid, k)) {
                low = mid + 1;
                answer = mid;
            } // 2.2 건너지 못하는 경우 high를 줄인다.
            else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean isTrue(int[] stones, int mid, int k) {
        int cnt = 0;

        for (int stone : stones) {
            // 3. 징검다리에서 건너지 못하는 칸 수를 센다.
            if (stone - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }

            // 4. cnt가 k와 동일하면 다리를 건너지 못한다.
            if (cnt == k) {
                return false;
            }
        }

        return true;
    }
}
