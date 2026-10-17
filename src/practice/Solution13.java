/*
 * 問題 3：条件を満たす数字の並び
 *
 * 1～9の数字から異なる6個を選び、
 * それらを並べて長さ6の数列を作成します。
 *
 * 次のすべての条件を満たす数列の個数を求めてください。
 *
 * 【条件】
 * 1. 同じ数字は2回以上使用できません。
 * 2. 隣り合う2つの数字の差の絶対値は3以上であること。
 * 3. 数列の先頭の数字は奇数であること。
 * 4. 数列の6個の数字の合計は30以上であること。
 *
 * 【例】
 * [1, 4, 7, 2, 5, 8]
 * → 隣接する数字の差がすべて3以上
 * → 先頭が奇数
 * → 合計27なので条件を満たさない
 *
 * [3, 7, 2, 8, 4, 9]
 * → 隣接する数字の差がすべて3以上
 * → 先頭が奇数
 * → 合計33なので条件を満たす
 *
 * 【実装条件】
 * ・Javaを使用すること
 * ・DFSまたはバックトラッキングで実装すること
 * ・条件を満たす数列の個数を標準出力に表示すること
 *
 * 目標時間：10～12分
 */

class Solution13 {
    int count = 0;
    public void main(String[] args) {
        int n = 9;
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                visited[i] = true;
                dfs (nums[i], visited, nums[i], 1);
                visited[i] = false;
            }
        }

        System.out.println(count);
    }

    private void dfs(int num, boolean[] visited, long sum, int len) {
        if (len == 6) {
            if (sum >= 30 ) {
                count++;
            }
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && Math.abs(num - (i+1)) >= 3) {
                visited[i] = true;
                dfs (i + 1, visited, sum + (i + 1), len + 1);
                visited[i] = false;
            }
        }
    }
}
