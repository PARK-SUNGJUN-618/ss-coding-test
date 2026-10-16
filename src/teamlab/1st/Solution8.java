/*
 * 問題8：グリッド上の経路数
 *
 * 縦15マス、横15マスのグリッドがあります。
 *
 * 左上のマス(0, 0)から右下のマス(14, 14)まで
 * 移動する経路の総数を求めてください。
 *
 * 【移動ルール】
 * ・現在のマスから右または下に1マスだけ移動できます。
 * ・グリッドの外には移動できません。
 * ・障害物のあるマスには移動できません。
 *
 * 【障害物】
 * 以下の条件を満たすマスは障害物です。
 *
 * (row + col) % 7 == 0
 *
 * ただし、スタート(0, 0)と
 * ゴール(14, 14)は障害物ではありません。
 *
 * 【例】
 * 3×3のグリッドで障害物がない場合、
 * 左上から右下までの経路は6通りです。
 *
 * 【問題】
 * 指定された15×15のグリッドについて、
 * スタートからゴールまでの経路数を
 * 求めてください。
 *
 * 【出力】
 * 経路数を1000000007で割った余りを
 * 整数で出力してください。
 *
 * 【注意】
 * ・同じマスを複数回通ることはできません。
 * ・Java 11の標準機能のみ使用できます。
 */

class Solution8 {
    
    
    static long answer = 0;

    public static void main(String[] args) {
        int rows = 15;
        int cols = 15;
        long mod = 1000000007L;


        boolean[][] visited = new boolean[rows][cols];

        dfs(0, 0, visited);


        System.out.println(answer % mod);
    }

    private static void dfs(int i, int j, boolean[][] visited) {
        if (i == 14 && j == 14) {
            answer++;
            return;
        }

        if ((i + j) != 0 && (i + j) % 7 == 0) return;

        visited[i][j] = true;

        if (j < 14 && !visited[i][j + 1]) {
            dfs(i, j + 1, visited);
        }

        if (i < 14 && !visited[i + 1][j]) {
            dfs(i + 1, j ,visited);
        }
    }
}
