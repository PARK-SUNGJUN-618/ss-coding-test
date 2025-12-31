

class Solution {
    /*
    * Find the shortest path to the destination.
    *
    * Problem:
    * Starting from the top-left corner (0,0), move to the bottom-right corner
    * (N-1,M-1) in the minimum number of steps.
    * You can move only up, down, left, or right through cells with value 1.
    * Return -1 if the destination cannot be reached.
    *
    * Example:
    * Input :
    * [[1,0,1,1,1],
    *  [1,0,1,0,1],
    *  [1,0,1,1,1],
    *  [1,1,1,0,1],
    *  [0,0,0,0,1]]
    *
    * Output: 11
    *
    * @param maps 2D game map (1 = path, 0 = wall)
    * @return Minimum number of cells in the shortest path, or -1 if unreachable
    */
    private int solution(int[][] maps) {
        int[] moveX = {1, -1, 0 ,0};
        int[] moveY = {1, -1, 0 ,0};



        int count = 0;
        // return count
        return count;
    }

    public static void main(String[] args) {
        int[][] input = {
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,1},
            {0,0,0,0,1}
        };

        Solution sol = new Solution();
        int output = sol.solution(input);
        System.out.println(output);
    }
}
