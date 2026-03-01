public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        int nrow = s.length();
        int ncolumn = p.length();

        // base condition
        if (nrow == 0 && ncolumn == 0) return true;
        if (ncolumn == 0) return false;

        // buffer 1 element for empty
        // dp[r][c] means pattern from 0 -> c can match with string from 0 -> r
        boolean[][] dp = new boolean[nrow + 1][ncolumn + 1];

        dp[0][0] = true;

        // process empty string first
        for (int c = 2; c < ncolumn + 1; c++) {
            if (charP[c - 1] == '*') {
                dp[0][c] = dp[0][c - 2];
            }
        }

        for (int r = 1; r < nrow + 1; r++) {
            for (int c = 1; c < ncolumn + 1; c++) {
                if (charS[r - 1] == charP[c - 1] || charP[c - 1] == '.') {
                    // match -> the result is depended on the previous
                    dp[r][c] = dp[r - 1][c - 1];
                } else if (c > 1 && charP[c - 1] == '*') {
                    // using * 0 time -> * and the prev char in pattern is removed -> depend on the pattern WITHOUT * and the prev char
                    dp[r][c] = dp[r][c - 2];
                    if (charP[c - 2] == '.' || charP[c - 2] == charS[r - 1]) {
                        // using * >= 1 times -> remove the last char of string because it already match -> keep * and the prev char in case of match > 1 time
                        dp[r][c] = dp[r][c] | dp[r - 1][c];
                    }
                }
            }
        }

        return dp[nrow][ncolumn];
    }

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        String s = "addddddef";
        String p = "c*ad*ef";
        System.out.println(rem.isMatch(s, p));
    }
}
