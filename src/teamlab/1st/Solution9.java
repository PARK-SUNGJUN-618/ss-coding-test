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


class Solution9 {
    static long answer = 0;
    static char[] strList = {'A', 'B', 'C'};

    public static void main(String[] args) {
        int length = 20;
        int countA = 7;
        int countB = 6;
        int countC = 7;

        long mod = 1000000007L;

        
        dfs(strList[0], "" + strList[0], countA - 1, countB, countC);
        dfs(strList[1], "" + strList[1], countA, countB - 1, countC);
        dfs(strList[2], "" + strList[2], countA, countB, countC - 1);


        System.out.println(answer % mod);
    }

    private static void dfs(char nowStr, String curStr, int countA, int countB, int countC) {
        if (curStr.length() > 2 
                && nowStr == curStr.charAt(curStr.length() - 2)
                && nowStr == curStr.charAt(curStr.length() - 3)
        ) {
            return;
        }

        if (curStr.length() == 20) {
            answer++;
            return;
        }

        // if (nowStr.equals("A")) cntList[0] -= 1;
        // if (nowStr.equals("B")) cntList[1] -= 1;
        // if (nowStr.equals("C")) cntList[2] -= 1;

        if (countA > 0) {
            dfs(strList[0], curStr + strList[0], countA - 1, countB, countC);
        }

        if (countB > 0) {
            dfs(strList[1], curStr + strList[1], countA, countB - 1, countC);
        }

        if (countC > 0) {
            dfs(strList[2], curStr + strList[2], countA, countB, countC - 1);
        }
    }
}
