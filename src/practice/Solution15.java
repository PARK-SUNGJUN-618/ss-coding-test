import java.util.*;
class Solution15 {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int R = sc.nextInt();

        // System.out.println("N:" + N + ",X:" + X + ",R:" + R);
        int[] dp = new int[X + 1];
        Arrays.fill(dp, -1);
        dp[X] = 0;
        
        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            int s = sc.nextInt();
            
            int[] next = new int[X + 1];
            Arrays.fill(next, -1);

            for (int j = 0; j <= X; j++) {
                if (dp[j] == -1) {
                    continue;
                }

                int rest = Math.min(X, j + R);
                next[rest] = Math.max(next[rest], dp[j]);

                if (j >= s) {
                    next[j - s] = Math.max(next[j - s], dp[j] + t);
                } 
            }
            
            dp = next;
        }

        int answer = 0;
        for (int value : dp) {
            answer = Math.max(answer, value);
        }

        System.out.println(answer);
        sc.close();
    }
}
