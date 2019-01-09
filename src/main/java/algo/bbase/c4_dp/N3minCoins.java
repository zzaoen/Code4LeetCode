package algo.bbase.c4_dp;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/30 15:04
 * @desc :
 */
public class N3minCoins {

    public static void main(String[] args) {

        N3minCoins minCoins = new N3minCoins();

        int[] arr = new int[]{5, 2, 3};
        int aim = 20;
        /*int res1 = minCoins.minCoins1(arr, aim);
        System.out.println(res1);*/

        /*int res2 = minCoins.minCoins2(arr, aim);
        System.out.println(res2);*/

        arr = new int[]{5, 2, 3, 5};
        aim = 12;
        int res3 = minCoins.minCoins3(arr, aim);
        System.out.println(res3);

        return;
    }

    /*
     * 每种钱币只可以使用1次的情况
     */
    private int minCoins3(int[] arr, int aim) {
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];

        for (int i = 1; i <= aim; i++) {
            dp[0][i] = max;
        }
        if(arr[0] <= aim){
            dp[0][arr[0]] = 1;
        }

        int left = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= aim; j++){
                left = max;
                if(j - arr[i] >= 0 && dp[i-1][j-arr[i]] != max)
                    left = dp[i-1][j-arr[i]] + 1;

                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;

    }

    /*
     * 对空间进行优化
     */
    private int minCoins2(int[] arr, int aim) {
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];

        for (int i = 1; i <= aim; i++) {
            dp[i] = max;
            if (i - arr[0] >= 0 && dp[i - arr[0]] != max)
                dp[i] = dp[i - arr[0]] + 1;
        }

        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(dp[j], left);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[aim] != max ? dp[aim] : -1;
    }

    /*
     * 二维数组记录每一个钱数的情况
     */
    private int minCoins1(int[] arr, int aim) {
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int i = 1; i <= aim; i++) {
            dp[0][i] = max;
            if (i - arr[0] >= 0 && dp[0][i - arr[0]] != max) {
                dp[0][i] = dp[0][i - arr[0]] + 1;
            }
        }

        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max)
                    left = dp[i][j - arr[i]] + 1;

                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;

    }
}
