package algo.bbase.c4_dp;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/30 17:43
 * @desc :
 */
public class N5LongestIncSeq {

    public static void main(String[] args) {

        N5LongestIncSeq longestIncSeq = new N5LongestIncSeq();
        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] lis = longestIncSeq.getLIS(arr);
        System.out.println(Arrays.toString(lis));

        return;
    }

    private int[] getLIS(int[] arr) {
        int[] dp = getdp(arr); //拿到每个位置的最长递增序列长度
        int[] lis = generateLIS(arr, dp); //利用每个位置的长度推导出递增序列
        return lis;
    }

    private int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }

        int[] res = new int[len];
        res[--len] = arr[index];

        for(int i = index; i >=0; i--){
            if(arr[i] < arr[index] && dp[i] == dp[index]-1){
                res[--len] = arr[i];
                index = i;
            }
        }

        return res;
    }

    private int[] getdp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 0;
        for(int i = 1; i < arr.length; i++){
            max = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[j] > max){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }

        System.out.println(Arrays.toString(dp));
        return dp;
    }
}
