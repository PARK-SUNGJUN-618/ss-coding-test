class Solution8 {
    /*
    * Count the number of networks.
    *
    * Problem:
    * Given n computers and their connection information,
    * count how many separate networks exist.
    * Computers are considered to be in the same network
    * if they are directly or indirectly connected.
    *
    * Example:
    * Input :
    * n = 3
    * [[1,1,0],
    *  [1,1,0],
    *  [0,0,1]]
    *
    * Output: 2
    *
    * @param n Number of computers
    * @param computers Adjacency matrix representing computer connections
    *                  (1 = connected, 0 = not connected)
    * @return Number of separate networks
    */
    public int solution(int n, int[][] computers) {
        int result = 0;

        // create checked boolean list
        this.visited = new boolean[n];
        this.computers = computers;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }

        
        return result;
    }

    private void dfs(int current) {
        visited[current] = true;

        for (int next = 0;next < computers[current].length; next++) {
            if (!visited[next] && computers[current][next] == 1) {
                dfs(next);
            }
        }
    }

    private boolean[] visited;
    private int[][] computers;

    public static void main(String[] args) {
        int n = 3;

        int[][] computers = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        // int[][] computers = {
        //     {1, 1, 0},
        //     {1, 1, 1},
        //     {0, 1, 1}
        // };

        Solution8 sol = new Solution8();
        int result = sol.solution(n, computers);
        System.out.println(result);
    }
}
