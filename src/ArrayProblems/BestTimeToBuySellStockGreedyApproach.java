package ArrayProblems;

public class BestTimeToBuySellStockGreedyApproach {
    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        for (int price : prices) {

            // Update minimum price
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate profit
            int profit = price - minPrice;

            // Update max profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
    }
}
