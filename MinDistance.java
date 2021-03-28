/*
583. Delete Operation for Two Strings
Given two strings word1 and word2, return the minimum number of steps required
to make word1 and word2 the same.
In one step, you can delete exactly one character in either string.
*/
class MinDistance {

    public int minDistance(String word1, String word2) {

        int memo[][] = new int[word2.length() + 1][word1.length() + 1];
        memo[0][0] = 0;
        for (int row = 1; row < word2.length() + 1; row++) {
            memo[row][0] = row;
        }
        for (int col = 1; col < word1.length() + 1; col++) {
            memo[0][col] = col;
        }
        for (int row = 1; row < word2.length() + 1; row++) {
            for (int col = 1; col < word1.length() + 1; col++) {
              int minimum = Math.min(memo[row][col - 1], memo[row - 1][col]) + 1;
              if (word1.charAt(col - 1) == word2.charAt(row - 1)) {
                memo[row][col] = Math.min(minimum, memo[row - 1][col - 1]);
              } else {
                memo[row][col] = minimum;
              }
            }
        }
        return memo[word2.length()][word1.length()];
    }
}
