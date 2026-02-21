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

        //
        
        return answer;
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
