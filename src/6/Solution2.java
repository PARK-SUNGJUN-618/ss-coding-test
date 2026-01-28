import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
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
        // int[] moveY = {1, -1, 0 ,0};
        // int[] moveX = {0 ,0, 1, -1};
        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        int m = maps.length;
        int n = maps[0].length;
        // for debug
        // System.out.println("m:" + m + ", n:" + n);
        boolean[][] visited = new boolean[m][n];
        
        Queue<Node> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.offer(new Node(0, 0, 1));

        while(!queue.isEmpty()) {
            Node curr = queue.poll();

            int y = curr.y;
            int x = curr.x;
            int dist = curr.dist;
            // for debug
            // System.out.println("y:" + y + ", x:" + x + ", dist:" + dist);


            // Destination reached
            if (y == m - 1 && x == n - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int nextY = y + dir[0];
                int nextX = x + dir[1];

                // skip if out of bounds
                if (isOutOfBounds(nextY, nextX, m, n)) {
                    continue;
                }
                // skip if already visited
                if (visited[nextY][nextX]) {
                    continue;
                }
                // skip if it is a wall
                if (maps[nextY][nextX] == 0) {
                    continue;
                }

                visited[nextY][nextX] = true;
                queue.offer(new Node(nextY, nextX, dist + 1));
            }
        }

        // return -1
        return -1;
    }

    public boolean isOutOfBounds(int y, int x, int m, int n) {
        return y < 0 || x < 0 || y >= m || x >= n;
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

class Node {
    int y;
    int x;
    int dist;

    Node(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}