/*
【第6問】条件を満たす3要素の組合せ

長さ300の整数配列 A を生成します。

A[i] = (int)((i * 41L + 17) % 100) + 1;
（0 <= i < 300）

異なる3つのインデックス i, j, k を選びます。

以下の条件をすべて満たす組合せの数を
求めてください。

【条件】
1. 0 <= i < j < k < 300
2. A[i] + A[j] + A[k] は 7 の倍数である。
3. A[i], A[j], A[k] はすべて異なる。
4. A[i] < A[k]

【制約】
・配列の長さ：300
・実行時間制限：2秒
・使用言語：Java

【解答形式】
条件を満たす組合せの数を整数で回答してください。
*/

class Solution3_6 {
    public static void main(String[] args) {
        int N = 300;
        int[] A = new int[N];

        for (int i = 0; i < A.length; i++) {
            A[i] = (int)((i * 41L + 17) % 100) + 1;
        }

        long count = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if ((A[i] + A[j] + A[k]) % 7 == 0) {
                        if (A[i] != A[j] && A[j] != A[k] && A[k] != A[i]) {
                            if (A[i] < A[k]) {
                                count++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
