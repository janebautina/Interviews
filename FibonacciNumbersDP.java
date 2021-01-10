/*
DP Solution for Fibonacci Numbers
Time Complexity: O(n)
Space: O(1)
*/

class FibonacciNumbersDP {
  public int fib(int N) {
    if (N <= 1) {
        return N;
    }
    int prev = 1;
    int prevPrev = 0;
    int current = 0;
    for (int i = 2; i <= N; i++) {
      current = prev + prevPrev;
      prevPrev = prev;
      prev = current;
    }
    return current;
  }
}
