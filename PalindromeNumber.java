public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reverse = reverse(x);
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

    public int reverse(int x) {
        boolean isNegative = false;
        int result = 0;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        while (x > 0) {
            int lastDigit = x % 10;
            if (result != 0) {
                if (result >= 214748365) return 0; // trường hợp vượt quá khoảng giới hạn của số int
                result = result * 10 + lastDigit;
            } else {
                result += lastDigit;
            }

            x /= 10;
        }

        return isNegative ? -result : result;
    }
}
