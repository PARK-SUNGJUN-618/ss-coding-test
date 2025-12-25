import java.util.HashSet;
import java.util.Iterator;

class Solution {
    /*
     * Find the prime numbers.
     *
     * Problem:
     * Generate all possible numbers from the given digit pieces
     * (using 1 ~ N digits) and count the number of unique prime numbers.
     *
     * Example:
     * Input : "17"
     * Output: 3 (7, 17, 71)
     *
     * @param numbers String containing digit pieces (e.g. "011")
     * @return Number of unique prime numbers
     */
    private int solution(String numbers) {
        // Find number set
        findNumberSet("", numbers);
        // for debug of number set
        // System.out.println(numberSet);

        // Count prime number
        int count = 0;
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()) {
            int number = it.next();
            if (isPrimeNum(number)) {
                count++;
            }
        }
        

        // return count
        return count;
    }

    // find number set
    HashSet<Integer> numberSet = new HashSet<>();
    private void findNumberSet(String nowNum, String others) {
        if (!nowNum.equals("")) {
            numberSet.add(Integer.valueOf(nowNum));
        }

        for (int i = 0; i < others.length(); i++) {
            findNumberSet(nowNum + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }        
    }

    public static void main(String[] args) {
        String input = "17";
        
        Solution sol = new Solution();
        int output = sol.solution(input);
        System.out.println(output);
    }
}
