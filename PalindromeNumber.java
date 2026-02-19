public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reverse = 0;
        int temp = x;
        while (temp > 0) {
            if (reverse >= 214748365) return false; // trường hợp vượt quá khoảng giới hạn của số int

            int lastDigit = temp % 10;
            reverse = reverse * 10 + lastDigit;
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

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reverse = 0;

        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return x == reverse || x == reverse / 10;
    }
}
