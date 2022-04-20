import java.util.Arrays;

/**
 * @source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * similar to https://leetcode.com/problems/maximum-subarray/
 */

public class TimeToBuyAndSellStocks {
    // runtime is O(n2)
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int diff;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                diff = prices[j] - prices[i];
                if (diff > max) {
                    max = diff;
                }
            }
        }
        return Math.max(max, 0);
    }

    // runtime is O(n2)
    public static int maxProfitFast(int[] prices) {
        int len = prices.length;
        int diff = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            diff = Math.max(0, diff + prices[i] - prices[i-1]);
            max = Math.max(diff, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(Arrays.toString(prices));
        System.out.println(maxProfitFast(prices));
    }
}
