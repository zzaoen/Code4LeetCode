package algo.bbase.c4_dp;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/31 12:56
 * @desc :
 */
public class N6LongestCommonSeq {

    public static void main(String[] args) {
        N6LongestCommonSeq longestCommonSeq = new N6LongestCommonSeq();

        String str1 = "A1BC2";
        String str2 = "AB34C";
        String res = longestCommonSeq.getLCS(str1, str2);
        System.out.println(res);
        return;
    }

    private String getLCS(String str1, String str2) {
//        String res = null;
        int[][] dp = getDp(str1, str2);

        int row = str1.length()-1;
        int col = str2.length()-1;
        char[] res = new char[dp[row][col]];
        int index = res.length - 1;
        while(index >= 0){
            if(row > 0 && dp[row][col] == dp[row-1][col])
                row--;
            else if(col > 0 && dp[row][col] == dp[row][col-1])
                col--;
            else {
//                res[index--] = str1.charAt(row);
                res[index--] = str2.charAt(col);
                row--;
                col--;
            }
        }


        return new String(res);
    }



    private int[][] getDp(String str1, String str2) {
        int row = str1.length();
        int col = str2.length();
        int[][] dp = new int[row][col];
        char[] charsStr1 = str1.toCharArray();
        char[] charsStr2 = str2.toCharArray();
        dp[0][0] = charsStr1[0] == charsStr2[0] ? 1 : 0;
        int tmp = 0;
        for(int i = 1; i < row; i++){
            tmp = charsStr1[i] == charsStr2[0] ? 1 : 0;
            dp[i][0] = Math.max(tmp, dp[i-1][0]);
        }
        for(int i = 1; i < col; i++){
            tmp = charsStr2[i] == charsStr1[0] ? 1 : 0;
            dp[0][i] = Math.max(tmp, dp[0][i-1]);
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(charsStr1[i] == charsStr2[j]){
                    dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i][j]);
                }
            }
        }


        for(int i = 0; i < dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp;
    }
}
