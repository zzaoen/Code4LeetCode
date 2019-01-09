package leetcode.array;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/10/2 18:41
 * @desc :
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] arr = new int[]{
                7, 1, 5, 3, 6, 4
        };
        System.out.println(maxProfit1(arr));
        return;
    }

    /*
     * 买卖股票的最佳时机
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
     * 这种是一天只交易一次，找到最大的利润值就可以了
     */
    public static int maxProfit1(int[] prices) {
        int res = 0;

        return res;
    }


    //
    public static int maxProfit2(int[] prices) {
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                res += (prices[i] - prices[i - 1]);
        }
        return res;
    }


}
