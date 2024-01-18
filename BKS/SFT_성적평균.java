package BKS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SFT_성적평균 {
    // 20240118 12:19 ~ 12:39
    static int N, K;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        scores = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        double result = 0;
        double sum = 0;

        for (int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for (int j = start - 1 ; j < end ; j++) {
                cnt++;
                sum += (double) scores[j];
            }
            result = sum / (double)cnt;
            // 방법1
            // System.out.printf("%.2f", result);
            // System.out.println();

            // 방법2
            System.out.println(String.format("%.2f", result));
            cnt = 0;
            sum = 0;
        }
    }
}
