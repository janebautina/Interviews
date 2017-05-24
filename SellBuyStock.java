import java.util.*;
/*Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
class SellBuyStock {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
          return 0;
        int maxP = Integer.MIN_VALUE;
        int localMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] >= localMin) {
                if(prices[i] - localMin > maxP)
                    maxP = prices[i] - localMin;
            }
            else{
               localMin = prices[i]; 
            }
        }
        return maxP;
    }
}
