//https://leetcode.com/problems/length-of-last-word
class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int sum = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != ' ') {
           sum++;
            i--;
        }
        return sum;
    }
}
