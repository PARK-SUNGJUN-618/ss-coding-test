class Solution {
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
        return 0;
    }

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

        Solution sol = new Solution();
        int output = sol.solution(n, computers);

        System.out.println(output);
    }
}
