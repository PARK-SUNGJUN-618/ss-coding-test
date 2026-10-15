/*
【第7問】条件付き数字列の生成

1から9までの数字を使って、
長さ6の数字列を作成します。

以下の条件をすべて満たす数字列の
総数を求めてください。

【条件】
1. 同じ数字は2回以上使用できない。
2. 隣り合う数字の差の絶対値は2以上。
3. 最初の数字は偶数である。
4. 6個の数字の合計は30以上である。
5. 最後の数字は最初の数字より大きい。

【例】
数字列 2, 5, 3, 7, 4, 9 は、
すべての条件を満たします。

【制約】
・使用できる数字：1～9
・数字列の長さ：6
・実行時間制限：2秒
・使用言語：Java

【解答形式】
条件を満たす数字列の総数を
整数で回答してください。
*/

class Solution7 {
    public static void main(String[] args) {
        long result = 0;
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if ((i + 1) % 2 == 0) {
                used[i] = true;
                // start, now, sum, used
                result += dfs(i, i, i+1, 1, used);
                used[i] = false;
            }
        }

        System.out.println(result);
    }

    private static long dfs(int start, int now, int sum, int count, boolean[] used) {
        if (count == 6) {
            if (sum >= 30) {
                if (now > start) {
                    return 1;
                }
            }

            return 0;
        }

        long result = 0;

        for (int i = 0; i < 9; i++) {

            if (!used[i]) {
                if (Math.abs(now - i) >= 2) {
                    used[i] = true;
                    result += dfs(start, i, sum + i + 1, count + 1, used);
                    used[i] = false;
                }
            }
        }

        return result;
    }
}
