/*
問題4：条件付きの文字列生成

文字 'A', 'B', 'C' の3種類を使用して、
長さ10の文字列を作成します。

次の条件をすべて満たす文字列が何通りあるか求めてください。

【条件】
1. 'A' をちょうど4回使用する。
2. 'B' をちょうど3回使用する。
3. 'C' をちょうど3回使用する。
4. 同じ文字が隣り合ってはいけない。
5. 文字列の先頭と末尾は異なる文字でなければならない。
6. 部分文字列 "ABC" が少なくとも1回含まれている。

【出力】
すべての条件を満たす文字列の総数を出力してください。

【制約】
・文字列の長さは10
・使用できる文字は A, B, C のみ
・Javaで実装してください。

【実行例】
（入力なし）

出力：
条件を満たす文字列の総数

【目標時間】
12〜15分
*/

class Solution14 {
    boolean[][][][][][][] memoCheck = new boolean[5][4][4][3][3][2][2];
    long[][][][][][][] memo = new long[5][4][4][3][3][2][2];
    public void main(String[] args) {


        long result = 0;
        result += dfs(3, 3, 3, 0, 0, false, false);
        result += dfs(4, 2, 3, 1, 1, false, false);
        result += dfs(4, 3, 2, 2, 2, false, false);
        System.out.println(result);
    }

    private long dfs(int cntA, int cntB, int cntC, int curStr, int firstStr, boolean isABC, boolean isAB) {
        if (memoCheck[cntA][cntB][cntC][curStr][firstStr][isABC?1:0][isAB?1:0]) {
            return memo[cntA][cntB][cntC][curStr][firstStr][isABC?1:0][isAB?1:0];
        }
        if (cntA == 0 && cntB == 0 && cntC == 0) {
            if (firstStr != curStr && isABC) {
                return 1;
            } else {
                return 0;
            }
        }

        long count = 0;

        if (cntA > 0 && curStr != 0) {
            count += dfs(cntA - 1, cntB, cntC, 0, firstStr, isABC, false);
        }
        if (cntB > 0 && curStr != 1) {
            if (curStr == 0) {
                count += dfs(cntA, cntB - 1, cntC, 1, firstStr, isABC, true);
            } else {
                count += dfs(cntA, cntB - 1, cntC, 1, firstStr, isABC, false);
            }
        }
        if (cntC > 0 && curStr != 2) {
            if (isAB) {
                count += dfs(cntA, cntB, cntC - 1, 2, firstStr, true, false);
            } else {
                count += dfs(cntA, cntB, cntC - 1, 2, firstStr, isABC, false);
            }
        }

        memoCheck[cntA][cntB][cntC][curStr][firstStr][isABC?1:0][isAB?1:0] = true;
        memo[cntA][cntB][cntC][curStr][firstStr][isABC?1:0][isAB?1:0] = count;

        return count;
    }
}
