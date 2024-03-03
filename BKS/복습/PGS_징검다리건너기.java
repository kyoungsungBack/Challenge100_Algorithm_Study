package BKS.복습;

public class PGS_징검다리건너기 {
    // 20240302 18:31 ~ 21:22 다시 복습
    // 20240303 10:32 ~ 10:45
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int answer = 0;
        // 1. 해당 징검다리를 건널 수 있는 최대인원(최적의 해)을 찾는다.
        int low = 1;
        int high = 200000000;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            // 2. 건널 수 있으면 -> low를 mid + 1로 증가시킨다.
            if (isOkay(mid, stones, k)) {
                low = mid + 1;
                answer = mid;
            } // 3. 건널 수 없으면 -> high를 mid - 1로 감소시킨다.
            else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
    public static boolean isOkay(int mid, int[] stones, int k) {
        int cnt = 0;
        for (int stone : stones) {
            // 4.1. 현재 다리를 못건널 경우 cnt 증가한다.
            if (stone - mid < 0) {
                cnt++;
            } // 4.2. 현재 다리를 건널 수 있는 경우 cnt를 0으로 세팅한다.
            else {
                cnt = 0;
            }

            // 4.3. 연속으로 다리를 k개 만큼 못건너면 false 반환한다.
            if (cnt == k) {
                return false;
            }
        }

        // 4.4. 다리를 건널 수 있는 경우 true를 반환한다.
        return true;
    }
}
