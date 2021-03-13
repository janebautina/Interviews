class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return "0";
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            char charA = (i >= 0)? a.charAt(i) : '0';
            char charB = (j >= 0)? b.charAt(j) : '0';
            sum += (charA - '0') + (charB - '0');
            i--;
            j--;

            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}
