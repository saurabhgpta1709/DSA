package TwoPointers;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {

        int left = 0;   // buy day
        int right = 1;  // sell day

        int maxProfit = 0;

        while (right < prices.length) {

            // profitable transaction
            if (prices[right] > prices[left]) {

                int profit = prices[right] - prices[left];

                maxProfit = Math.max(maxProfit, profit);
            }
            else {
                // move buy pointer
                left = right;
            }

            right++;
        }

        return maxProfit;
    }
}
