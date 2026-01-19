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
        System.out.println("m:" + m + ", n:" + n);
        boolean[][] visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();

        int[] start = {0, 0 ,1};
        visited[0][0] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int[] nowQueue = queue.poll();

            int y = nowQueue[0];
            int x = nowQueue[1];
            int dist = nowQueue[2];
            System.out.println("y:" + y + ", x:" + x + ", dist:" + dist);


            // Destination reached
            if (y == m - 1 && x == n - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + moveY[i];
                int nextX = x + moveX[i];

                // skip if out of map
                if (nextY < 0 || nextX < 0 || nextY > m - 1 || nextX > n - 1) {
                    continue;
                }
                if (visited[nextY][nextX] || maps[nextY][nextX] == 0) {
                    continue;
                }

                visited[nextY][nextX] = true;
                int[] addQueue = {nextY, nextX, dist + 1};
                queue.offer(addQueue);
            }
        }

        // return -1
        return -1;
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
