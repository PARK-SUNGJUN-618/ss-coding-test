import java.util.LinkedList;
import java.util.Queue;

class Solution9 {
    /*
     * Find the shortest path to the item along the boundary.
     *
     * Problem:
     * Given multiple overlapping rectangles that form a polygon,
     * move the character along the outer boundary of the terrain.
     * The character can move up, down, left, or right along the boundary.
     * Find the shortest distance from the character to the item.
     *
     * Example:
     * Input :
     * rectangle = {
     *     {1, 1, 7, 4},
     *     {3, 2, 5, 5},
     *     {4, 3, 6, 9},
     *     {2, 6, 8, 8}
     * }
     *
     * character = (1, 3)
     * item = (7, 8)
     *
     * Output: 17
     *
     * @param rectangle Array of rectangles represented by
     *                  {left, bottom, right, top}
     * @param characterX Character's starting X coordinate
     * @param characterY Character's starting Y coordinate
     * @param itemX Item's X coordinate
     * @param itemY Item's Y coordinate
     * @return Minimum distance along the boundary to reach the item
     */
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        for (int i = 0; i < rectangle.length; i++) {
            int y1=rectangle[i][1];
            int x1=rectangle[i][0];
            int y2=rectangle[i][3];
            int x2=rectangle[i][2];  
            draw(y1 * 2, x1 * 2, y2 * 2, x2 * 2);
        }

        // for debug
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        answer = bfs(characterY*2, characterX*2, itemY*2, itemX*2);

        return answer;
    }

    // int mapLength = 101;
    int mapLength = 20;
    int[][] map = new int[mapLength][mapLength];

    public int bfs(int Y,int X,int findY,int findX){
        int yy[] = {-1,1,0,0};
        int xx[] = {0,0,-1,1};
        boolean visited[][]=new boolean[mapLength][mapLength];
        Queue<Integer[]> queue = new LinkedList<>();

        queue.offer(new Integer[]{Y,X,0});

        while (!queue.isEmpty()) {
            Integer temp[] = queue.poll();

            int prevY = temp[0];
            int prevX = temp[1];
            int count = temp[2];

            if (prevY == findY && prevX == findX) {
                return count/2;
            }
            for(int i=0; i < 4; i++) {
                int nextY = prevY + yy[i];
                int nextX = prevX + xx[i];
                if(nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length) {
                    continue;
                }
                if(visited[nextY][nextX] == true || map[nextY][nextX] != 2) {
                    continue;
                }
                
                visited[nextY][nextX]=true;
                
                queue.offer(new Integer[]{nextY,nextX,count+1});
            }
        }
        
        return 0;
    }

    public void draw(int y1, int x1, int y2, int x2){
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
            	if (map[i][j] == 1) {
                    continue;
                }
                map[i][j] = 1;
                if (i == y1 || i == y2 || j == x1 || j == x2) {
                    map[i][j] = 2;
                }
            }
        }
        
    }

    public static void main(String[] args) {

        int[][] rectangle = {
            {1, 1, 7, 4},
            {3, 2, 5, 5},
            {4, 3, 6, 9},
            {2, 6, 8, 8}
        };

        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        /*
        int[][] rectangle = {
            {1, 1, 8, 4},
            {2, 2, 4, 9},
            {3, 6, 9, 8},
            {6, 3, 7, 7}
        };

        int characterX = 9;
        int characterY = 7;
        int itemX = 6;
        int itemY = 1;
        */

        Solution9 sol = new Solution9();
        int result = sol.solution(
            rectangle,
            characterX,
            characterY,
            itemX,
            itemY
        );

        System.out.println(result);
    }
}
