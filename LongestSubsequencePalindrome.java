/* Find the longest subsequence palindrome in a given array a. 
The longest subsequence palindrome of array a is a subsequence 
of indices i1 < i2 < ... < ik, where ai1ai2...aik is a palindrome.
*/

int longestSubsequencePalindrome(int[] a) {
    if(a == null || a.length == 0)
        return 0;
    int memo[][] = new int[a.length][a.length];
    for(int i = 0; i < a.length; i++)
        memo[i][i] = 1;
    int end;
    for (int len = 2; len <= a.length; len++) {
        for (int start = 0; start < a.length - len + 1; start++) {
            end = start + len - 1;
            if (a[start] == a[end]) {
                memo[start][end] = 2 + memo[start + 1][end - 1];
            }
            else {
                memo[start][end] = Math.max(memo[start + 1][end], memo[start][end - 1]);
            }
        }
    }
    return memo[0][a.length - 1];
}