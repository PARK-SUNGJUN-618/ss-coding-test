import java.util.LinkedList;
import java.util.Queue;

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
    public int solution(int[][] maps) {
        int[] moveY = {1, -1, 0 ,0};
        int[] moveX = {0 ,0, 1, -1};
        int m = maps.length;
        int n = maps[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();

        int[] start = {0, 0 ,1};
        visited[0][0] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int[] nowQueue = queue.poll();

            int y = nowQueue[0];
            int x = nowQueue[1];
            int dist = nowQueue[2];
            
            // Destination reached
            if (y == m - 1 && x == n - 1) {
                return dist;
            }

            // skip if out of map
            if (y < 0 || x < 0 || y > m - 1 || x > n - 1) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int[] addQueue = {y + moveY[i], x + moveX[i], dist + 1};
                queue.offer(addQueue);
            }
        }

        // return count
        return count;
    }

    public static void main(String[] args) {
        System.out.println("here?????????");
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
