package algo.bbase.c4_dp;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/30 14:17
 * @desc :
 */
public class N2MinPath {

    public static void main(String[] args) {

        N2MinPath minPath = new N2MinPath();
        int[][] arr = new int[][]{
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0},
        };

        /*int res1 = minPath.minPathSum1(arr);
        System.out.println(res1);*/

        int res2 = minPath.minPathSum2(arr);
        System.out.println(res2);
        return;
    }

    /*
     * 对算法的优化，使用以为的数组节省空间
     */
    private int minPathSum2(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        int[] dp = new int[row];
        dp[0] = arr[0][0];

        for(int i = 1; i < column; i++)
            dp[i] = dp[i-1] + arr[0][i];

        for(int i = 1; i < row; i++){
            dp[0] = dp[0] + arr[i][0];
            for(int j = 1; j < column; j++){
                dp[j] = Math.min(dp[j-1], dp[j]) + arr[i][j];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[column-1];
    }

    /*
     * 使用二维的数组计算每一个位置的值
     */
    private int minPathSum1(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }

        for(int i = 1; i < column; i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < column; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
            }
        }

        for(int i = 0; i < dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[row-1][column-1];
    }



}
