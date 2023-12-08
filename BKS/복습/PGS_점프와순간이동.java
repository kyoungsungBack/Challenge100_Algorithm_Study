package BKS.복습;

public class PGS_점프와순간이동 {
    public static void main(String[] args) {
        // 20231208 15:08 ~ 15:19
        int n = 5000;
        int ans = 0;
        // 5000 2500 1250 625 624(1) 312 156 78 39 38(2) 19 18(3) 9 8(4) 4 2 1 0(5)
        // 5 4(1) 2 1 0(2)
        // 6 3 2(1) 1 0(2)
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
