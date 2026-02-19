public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reverse = 0;
        int temp = x;
        while (temp > 0) {
            int lastDigit = temp % 10;
            if (reverse != 0) {
                if (reverse >= 214748365) return false; // trường hợp vượt quá khoảng giới hạn của số int
                reverse = reverse * 10 + lastDigit;
            } else {
                reverse += lastDigit;
            }

            temp /= 10;
        }
        return x == reverse;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        String sNum = String.valueOf(x);
        int length = sNum.length();
        for (int i = 0; i < length / 2; i++) {
            if (sNum.charAt(i) != sNum.charAt((length - 1) - i)) return false;
        }
        return true;
    }
}
