/*
 * 問題9：条件付き文字列の数え上げ
 *
 * 'A', 'B', 'C' の3種類の文字を使用して、
 * 長さ20の文字列を作成します。
 *
 * 以下の条件をすべて満たす文字列の
 * 総数を求めてください。
 *
 * 【条件】
 * 1. 文字列の長さはちょうど20である。
 *
 * 2. 同じ文字が3回以上連続してはならない。
 *    例：AAA、BBB、CCCは禁止。
 *
 * 3. 文字列に含まれる'A'の個数は
 *    ちょうど7個である。
 *
 * 4. 文字列に含まれる'B'の個数は
 *    ちょうど6個である。
 *
 * 5. 残りの文字はすべて'C'とする。
 *
 * 【例】
 * 長さ5、Aが2個、Bが1個、Cが2個の場合：
 *
 * "AACBC" → 条件を満たす
 * "ABCAC" → 条件を満たす
 * "AAABC" → 条件を満たさない
 *           （Aが3回連続）
 *
 * 【問題】
 * 長さ20の文字列について、
 * すべての条件を満たす文字列の
 * 総数を求めてください。
 *
 * 【出力】
 * 総数を1000000007で割った余りを
 * 10進数の整数として出力してください。
 *
 * 【注意】
 * ・文字列を実際にすべて生成する必要は
 *   ありません。
 * ・Java 11の標準機能のみ使用できます。
 */


class Solution9_2 {
    static long mod = 1000000007;
    static long[][][][][] memo = new long[8][7][8][4][3];
    static boolean[][][][][] visited = new boolean[8][7][8][4][3];
    public static void main(String[] args) {
        long count = 0;

        count += dfs(7, 6, 7, 3, 0);

        System.out.println(count % 1000000007);
    }

    private static long dfs(int cntA, int cntB, int cntC, int nowStr, int streak) {
        if (cntA == 0 && cntB == 0 && cntC == 0) {
            return 1;
        }
        
        if (visited[cntA][cntB][cntC][nowStr][streak]) {
            return memo[cntA][cntB][cntC][nowStr][streak];
        }

        long count = 0;

        if (cntA > 0 && !(nowStr == 0 && streak == 2)) {
            int nextStreak = (nowStr == 0) ? streak + 1 : 1;
            count += dfs(cntA - 1, cntB, cntC, 0, nextStreak);
        }
        if (cntB > 0 && !(nowStr == 1 && streak == 2)) {
            int nextStreak = (nowStr == 1) ? streak + 1 : 1;
            count += dfs(cntA, cntB - 1, cntC, 1, nextStreak);
        }
        if (cntC > 0 && !(nowStr == 2 && streak == 2)) {
            int nextStreak = (nowStr == 2) ? streak + 1 : 1;
            count += dfs(cntA, cntB, cntC - 1, 2, nextStreak);
        }

        count %= mod;

        visited[cntA][cntB][cntC][nowStr][streak] = true;
        memo[cntA][cntB][cntC][nowStr][streak] = count;

        return count;
    }
}
