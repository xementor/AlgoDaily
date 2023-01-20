package pattern.zero_1_knapsack.knapsack;

public class Solution {
  public int solveKnapsack(int[] profit, int[] weights, int capacity) {
    return this.knapsackRecursive(profit, weights, capacity, 0);
  }
  private int knapsackRecursive(int[] profit, int[] weights, int capacity, int currentIndex) {
    // base case
    if (capacity <= 0 || currentIndex >= profit.length) return 0;

    int profit1 = 0;
    if (weights[currentIndex] <= capacity)
      profit1 = profit[currentIndex] + knapsackRecursive(profit, weights, capacity - weights[currentIndex], currentIndex+1);
    
    int profit2 = knapsackRecursive(profit, weights, capacity, currentIndex+1);

    return Math.max(profit1, profit2);
  }


  /*
   * Top Down Dynamic Programing with Memoization
   */

  public int solveKnapsackTopDownMemoization(int[] profits, int[] weights, int capacity) {
    Integer[][] dp = new Integer[profits.length][capacity+1];
    return this.knapsackRecursiveMemo(dp, profits, weights, capacity, 0);
  }
  private int knapsackRecursiveMemo(Integer[][] dp, int[] profits, int[] weights, int capacity, int index) {
    if (capacity <= 0 || index >= profits.length) return 0;
    // if we have already solved this problem
    if (dp[index][capacity] != null) return dp[index][capacity];

    int profit1 = 0;
    if (weights[index] <= capacity) {
      profit1 = profits[index] + 
        knapsackRecursiveMemo(dp, profits, weights, capacity - weights[index], index+1);
    }

    int profit2 = knapsackRecursive(profits, weights, capacity, index+1);
    dp[index][capacity] = Math.max(profit1, profit2);
    return dp[index][index];
  }
  
  /**
   * Bottom Up Aproach of Dynamic Programing
   * @param profits
   * @param weights
   * @param capacity
   * @return
   */
  public int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) return 0;

    int n = profits.length;
    int[][] dp = new int[n][capacity+1];

    // popluate the capacity = 0 column with 0
    for (int c=0; c < n; c++) {
      if (weights[0] <= c)
        dp[0][c] = profits[0];
    }

    for (int i=1; i < n; i++) {
      for (int c=1; c <= capacity; c++) {
        int profit1 = 0, profit2 = 0;
        if (weights[i] < c)
          profit1 = profits[i] + dp[i-1][c-weights[i]];
        profit2 = dp[i-1][c];
      }
    }
    
    return dp[n-1][capacity];
  }
  
  /*
   * Same problem bottom up with space optimization
   */
  public static int solveKnapshackSpaace(int[] profits, int weights[], int capacity) {
    if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) return 0;
    int n = profits.length;

    int[][] dp = new int[2][capacity+1];

    for (int c=0; c <= capacity; c++) {
      if (weights[0] < c)
        dp[0][c] = dp[1][c] = profits[0];
    }

    for (int i=1; i < n; i++) {
      for (int c=0; c <= capacity; c++) {
        int profit1 = 0, profit2 = 0;
        if (weights[i] <= c)
          profit1 = profits[i] + dp[(i-1) % 2][c-weights[i]];
        profit2 = dp[(i-1)%2][c];
        dp[i%2][c] = Math.max(profit1, profit2);
      }
    }

    return dp[(n-1)%2][capacity];
  }


  public static int solveKnapsack1D(int[] profits, int[] weights, int capacity) {
    if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) return 0;

    int n = profits.length;

    int[] dp = new int[capacity+1];
    for (int c = 0; c <= capacity; c++) {
      if (weights[0] <= c) {
        dp[c] = profits[0];
      }
    }

    for (int i = 1; i < n; i++) {
      for (int c = capacity; c >= 0; c--) {
        int profit1 = 0, profit2 = 0;
        if (weights[i] <= c)
          profit1 = profits[i] + dp[c - weights[i]];
        profit2 = dp[c];

        dp[c] = Math.max(profit1, profit2);
      }
    }
    return dp[capacity];
  }
}