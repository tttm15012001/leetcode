public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                sb.append(s.charAt(j));
                j++;
            }
            int left = i - 1;
            int right = j;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    sb.insert(0, s.charAt(left));
                    sb.append(s.charAt(right));
                    left--;
                    right++;
                } else {
                    right = s.length();
                }
            }
            if (sb.length() > longest.length()) {
                longest = sb.toString();
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String s = "cbbd";
        System.out.println(lp.longestPalindrome(s));
    }
}
