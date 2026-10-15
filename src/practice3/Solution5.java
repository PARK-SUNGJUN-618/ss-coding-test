/*
【第5問】条件を満たす連続部分配列の数

長さ100000の整数配列 A を生成します。

A[i] = (int)((i * 47L + 31) % 100) + 1;
（0 <= i < 100000）

この配列から連続する区間 [l, r] を選びます。

区間内の要素の合計が500以下となる
区間の総数を求めてください。

【条件】
・0 <= l <= r < 100000
・A[l] + A[l+1] + ... + A[r] <= 500

【制約】
・配列の長さ：100000
・すべての要素は1以上100以下
・実行時間制限：2秒
・使用言語：Java

【解答形式】
条件を満たす連続部分配列の総数を
整数で回答してください。
*/

class Solution5 {
    public static void main(String[] args) {
        int N = 100_000;
        int K = 500;

        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int)((i * 47L + 31) % 100) + 1;
        }

        int left = 0;
        int sum = 0;
        long count = 0;

        for (int right = 0; right < N; right++) {
            sum += A[right];
 
            while (sum > K) {
                sum -= A[left];
                left++;
            }
        
            count += right - left + 1;
        }

        System.out.println(count);
    }
}
