class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;

        for (int i = 0 ; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        
        System.out.println("Min length:" + minLength );
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (currentChar != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(currentChar);
        }
        return sb.toString();
    }
}
