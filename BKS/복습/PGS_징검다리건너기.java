package BKS.복습;

public class PGS_징검다리건너기 {
    // 20240302 18:31 ~ 21:22 다시 복습
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int answer = 0;
        int low = 1;
        int high = 200000000;
        int mid = 0;

        // 1. 현재 징검다리에서 최대로 건널 수 있는 인원을 찾는다.
        //    최대를 찾을 땐 low에서 답을 찾는다.
        while (low <= high) {
            mid = (low + high) / 2;
            if (isOkay(mid, stones, k)) {
                low = mid + 1;
                answer = mid;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean isOkay(int mid, int[] stones, int k) {
        int cnt = 0;

        for (int stone : stones) {
            // 2. 못건너는 칸의 개수를 센다.
            if (stone - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }

            // 3. 연속으로 못건너는 칸이 k만큼 이면
            //    현재 인원이 건널 수 없으므로 false 반환한다.
            if (cnt == k) {
                return false;
            }
        }

        // 4. 현재 인원이 건널 수 있으면 true를 반환한다.
        return true;
    }
}
