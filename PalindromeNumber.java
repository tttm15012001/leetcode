public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String sNum = String.valueOf(x);
        int length = sNum.length();
        for (int i = 0; i < length / 2; i++) {
            if (sNum.charAt(i) != sNum.charAt((length - 1) - i)) return false;
        }
        return true;
    }
}
