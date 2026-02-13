class Solution8 {
    /*
    * Find the minimum number of transformations.
    *
    * Problem:
    * Transform the begin word into the target word
    * by changing only one letter at a time.
    * Each intermediate word must exist in the given word list.
    * Return the minimum number of transformations needed.
    * Return 0 if the target cannot be reached.
    *
    * Example:
    * Input :
    * begin = "hit"
    * target = "cog"
    * words = ["hot", "dot", "dog", "lot", "log", "cog"]
    *
    * Output: 4
    *
    * @param begin Starting word
    * @param target Target word
    * @param words List of available words for transformation
    * @return Minimum number of transformations, or 0 if impossible
    */
    public int solution(String begin, String target, String[] words) {
        int result = 0;

        return result;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";

        String[] words = {
            "hot",
            "dot",
            "dog",
            "lot",
            "log",
            "cog"
        };

        // String[] words = {
        //     "hot",
        //     "dot",
        //     "dog",
        //     "lot",
        //     "log"
        // };

        Solution8 sol = new Solution8();
        int result = sol.solution(begin, target, words);

        System.out.println(result);
    }
}
