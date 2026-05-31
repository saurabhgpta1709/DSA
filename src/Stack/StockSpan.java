package Stack;

import java.util.Arrays;
import java.util.Stack;

/*
The span of a stock's price on a given day is defined as:
The maximum number of consecutive days (including today) for which the stock price was less than or equal to today's price.
Input:
Price = [100, 80, 60, 70, 60, 75, 85]
Output:
Span = [1, 1, 1, 2, 1, 4, 6]
 */
public class StockSpan {
    public static void main(String[] args) {

        int[] prices =
                {100,80,60,70,60,75,85};

        System.out.println(
                Arrays.toString(
                        stockSpan(prices)));
    }

    public static int[] stockSpan(int[] prices) {

        int n = prices.length;

        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    prices[stack.peek()] <= prices[i]) {

                stack.pop();
            }

            span[i] = stack.isEmpty()
                    ? i + 1
                    : i - stack.peek();

            stack.push(i);
        }

        return span;
    }
}
