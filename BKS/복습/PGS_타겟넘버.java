package BKS.복습;

public class PGS_타겟넘버 {
    static int cnt = 0;
    // 20240602 15:17 ~ 15:53
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        sol(numbers, target, 0, 0);

        System.out.println(cnt);
    }
    public static void sol(int[] numbers, int target, int num, int len) {
        // 2. 모든 배열 확인했으면 종료
        if (len == numbers.length) {
            // 3. 이때, 타겟과 같으면 cnt 증가
            if (num == target) {
                cnt++;
            }
            return;
        }

        // 1. 현재 배열의 음수, 양수일 때를 계산하여 배열의 길이만큼 연산한다.
        sol(numbers, target, num + numbers[len], len + 1);
        sol(numbers, target, num - numbers[len], len + 1);
    }
}
