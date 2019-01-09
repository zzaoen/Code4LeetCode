package algo.bbase.c4_dp;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/30 16:24
 * @desc :
 */
public class N4ChangeCoins {

    public static void main(String[] args) {

        N4ChangeCoins changeCoins = new N4ChangeCoins();
        int[] arr = new int[]{5, 10, 25, 1};
        int aim = 1000;

        /*int res1 = changeCoins.coins1(arr, aim);
        System.out.println(res1);


        int res2 = changeCoins.coins2(arr, aim);
        System.out.println(res2);*/


        int res3 = changeCoins.coins3(arr, aim);
        System.out.println(res3);


        int res4 = changeCoins.coins4(arr, aim);
        System.out.println(res4);

        return;
    }

    /*
     * 动态规划的优化
     */
    private int coins4(int[] arr, int aim) {
        int row = arr.length;
        int[][] dp = new int[row][aim+1];

        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i * arr[0] <= aim; i++) {
            dp[0][i * arr[0]] = 1;
        }

        int num = 0;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] += ((j-arr[i] >= 0) ? dp[i][j-arr[i]] : 0);
            }
        }

        return dp[row - 1][aim];
    }

    /*
     * 动态规划方式
     */
    private int coins3(int[] arr, int aim) {
        int row = arr.length;
        int[][] dp = new int[row][aim+1];

        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i * arr[0] <= aim; i++) {
            dp[0][i * arr[0]] = 1;
        }

        int num = 0;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - k * arr[i]];
                }
                dp[i][j] = num;
            }
        }

        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[row - 1][aim];
    }

    /*
     * 记忆搜索法，保留中间计算过的值
     */
    private int coins2(int[] arr, int aim) {
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    private int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
//                    res += mapValue == -1? 0 : mapValue;
                    res += mapValue;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
//        map[index][aim] = res == 0 ? -1 : res;
        map[index][aim] = res;
        return res;
    }

    /*
     * 暴力递归的方式做
     */
    private int coins1(int[] arr, int aim) {
        return process1(arr, 0, aim);
    }

    private int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length)
            res = aim == 0 ? 1 : 0;
        else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }
}
