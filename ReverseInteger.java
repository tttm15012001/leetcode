public class ReverseInteger {
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

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int x = 120;
        System.out.println(ri.reverse(x));
    }
}
