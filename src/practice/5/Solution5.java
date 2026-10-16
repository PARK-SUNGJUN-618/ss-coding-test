import java.util.HashSet;
import java.util.Iterator;

class Solution5 {
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
    public int solution(String numbers) {
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

    private boolean isPrimeNum(int number) {
        // return false if number is 0 or 1 (not prime number)
        if (number == 0 || number == 1) {
            return false;
        }    

        int limit = (int) Math.sqrt(number);
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
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
        
        Solution5 sol = new Solution5();
        int output = sol.solution(input);
        System.out.println(output);
    }
}
