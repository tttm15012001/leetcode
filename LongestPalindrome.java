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

    public String longestPalindrome2(String s) {
        String longest = "";
        int maxLength = 0;
        char[] charS = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int right = i + 1;
            while (right < s.length() && charS[right] == charS[i]) {
                right++;
            }

            int left = i - 1;
            while (left >= 0 && right < s.length() && charS[right] == charS[left]) {
                left--;
                right++;
            }
            // tại đây thì left đã dịch sang trái và right đã dịch sang phải 1 đơn vị nên cần -2 đi
            if ((right - 1) - (left + 1) + 1 > maxLength) {
                // lấy left + 1 vì left + 1 là giá trị đúng, còn lấy đến right là vì substring trong java không lấy right, chỉ lấy < right (tương đương right - 1)
                longest = s.substring(left + 1, right);
                maxLength = right - (left + 1);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String s = "bb";
        System.out.println(lp.longestPalindrome2(s));
    }
}
