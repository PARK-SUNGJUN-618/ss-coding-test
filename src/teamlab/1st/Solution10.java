/*
 * 問題10：最小コストでゴールを目指す
 *
 * 0番から999番までの1000個のマスが
 * 一列に並んでいます。
 *
 * 0番のマスからスタートし、
 * 999番のマスまで移動するための
 * 最小コストを求めてください。
 *
 * 【移動ルール】
 *
 * 現在のマスiから、次のいずれかの
 * マスに移動できます。
 *
 * ・i + 1
 * ・i + 2
 * ・i + 3
 *
 * ただし、999番を超える移動はできません。
 *
 * 【移動コスト】
 *
 * マスiに移動したときのコストは、
 * 次の式で求められます。
 *
 * cost[i) = (i * i + 3 * i + 7) % 100
 *
 * スタート地点である0番のマスでは
 * コストは発生しません。
 *
 * 【追加条件】
 *
 * ・10の倍数のマスに移動する場合、
 *   通常のコストに50を加算します。
 *
 * ・7の倍数のマスに移動する場合、
 *   通常のコストから20を減算します。
 *
 * ・両方の条件を満たす場合は、
 *   両方の補正を適用します。
 *
 * ・補正後のコストが負数になる場合は、
 *   0として扱います。
 *
 * 【例】
 *
 * マス7の場合：
 * cost[7) = (49 + 21 + 7) % 100 = 77
 * 7の倍数なので、77 - 20 = 57
 *
 * マス10の場合：
 * cost[10] = (100 + 30 + 7) % 100 = 37
 * 10の倍数なので、37 + 50 = 87
 *
 * 【問題】
 *
 * 0番から999番まで移動するための
 * 最小コストを求めてください。
 *
 * 【出力】
 *
 * 最小コストを10進数の整数として
 * 出力してください。
 *
 * 【注意】
 * ・移動は常に番号が増える方向のみです。
 * ・各マスに到達するまでの経路は自由です。
 * ・Java 25で実装して構いません。
 */

class Solution {
    static long answer = 0;
    static int n = 1000;
    static long[] cost = new long[n];
    static long[] minCostMemo = new long[n];

    public static void main(String[] args) {

        cost[0] = 0;
        for (int i = 1; i < cost.length; i++) {
            cost[i] = (i * i + 3 * i + 7) % 100;
            if (i % 10 == 0) cost[i] += 50;
            if (i % 7 == 0) cost[i] -= 20;
            if (cost[i] < 0) cost[i] = 0;

            // System.out.println(i + ":" + cost[i]);
            minCostMemo[i] = -1;
        }
        
        minCostMemo[0] = cost[0];
        minCostMemo[1] = cost[1];
        minCostMemo[2] = cost[2];

        answer = getMinCost(n - 1);

        System.out.println(answer);
    }

    private static long getMinCost(int i) {
        if (minCostMemo[i] != -1) {
            return minCostMemo[i];
        }

        long result = Math.min(Math.min(getMinCost(i - 1), getMinCost(i - 2)), getMinCost(i - 3)) + cost[i];
        minCostMemo[i] = result;

        return result;
    }
}
