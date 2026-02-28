public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int fib3(int n, int[] mem) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (mem[n] != 0) return mem[n];

        mem[n] = fib3(n - 1, mem) + fib3(n - 2, mem);
        return mem[n];
    }

    public static void main(String[] args) {
        FibonacciNumber fib = new FibonacciNumber();

        int n = 5;
        int[] mem = new int[n + 1];
        mem[1] = 1;
        System.out.println(fib.fib3(5, mem));
    }
}
