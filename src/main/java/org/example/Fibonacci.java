package org.example;

public class Fibonacci {

    /**
     * Return the <code>n</code>th Fibonacci number.
     *
     * @param n the index into the Fibonacci series. <code>n</code> is positive and less than 93.
     * @return if <code>n</code> < 0 or <code>n</code> > 92 then -1;
     * else if <code>n</code> < 2 then <code>n</code>;
     * else <code>fibN(n-1)</code> + <code>fibN(n-2)</code>.
     */
    public long fibN(int n) {
        if (n < 0 || n > 92) {
            return -1L; // Out of bounds
        }
        if (memo[n] != 0 || n == 0) {
            return memo[n]; // Return cached value or 0 for F(0)
        }
        if (n < 2) {
            memo[n] = n; // F(0) = 0, F(1) = 1
        } else {
            memo[n] = fibN(n - 1) + fibN(n - 2); // Recursive calculation with memoization
        }
        return memo[n];
    }

    /**
     * Determine the sum of the first <code>n</code> Fibonacci numbers.
     *
     * @param n the index into the Fibonacci series. <code>n</code> is positive and less than 93.
     * @return the sum of the Fibonacci numbers 0 through n.
     */
    public long sumN(int n) {
        if (n < 0 || n > 92) {
            return -1L; // Out of bounds
        }
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += fibN(i); // Use fibN to compute the Fibonacci numbers
        }
        return sum;
    }

    public Fibonacci() {
        memo[0] = 0; // F(0)
        memo[1] = 1; // F(1)
    }

    private final long[] memo = new long[93];
}