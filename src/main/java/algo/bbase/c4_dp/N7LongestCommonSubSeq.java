package algo.bbase.c4_dp;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/31 13:57
 * @desc :
 */
public class N7LongestCommonSubSeq {

    public static void main(String[] args) {
        N7LongestCommonSubSeq longestCommonSubSeq = new N7LongestCommonSubSeq();
        String str1 = "abcde";
        String str2 = "bebcd";
        /*String lcss1 = longestCommonSubSeq.getLCSS1(str1, str2);
        System.out.println(lcss1);*/

        String lcss2 = longestCommonSubSeq.getLCSS2(str1, str2);
        System.out.println(lcss2);
        return;
    }


    /*
     * 空间复杂度为O(1)
     */
    private String getLCSS2(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] charsStr1 = str1.toCharArray();
        char[] charsStr2 = str2.toCharArray();

        int row = 0;
        int col = n - 1; //起始位置，右上角
        int end = 0, len = 0;

        while(row < n){
            int i = row;
            int j = col;

            int tmpLen = 0;
            while(i < m && j < n){
                if(charsStr1[i] != charsStr2[j])
                    tmpLen = 0;
                else
                    tmpLen++;

                if(tmpLen > len){
                    end = i;
                    len = tmpLen;
                }
                i++;
                j++;
            }
            if(col > 0) //斜线先往左移
                col--;
            else
                row++;
        }
        String res = str1.substring(end - len + 1, len + 1);
        return res;
    }

    /*
     * 二维数据的dp
     */
    private String getLCSS1(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] charsStr1 = str1.toCharArray();
        char[] charsStr2 = str2.toCharArray();
        int[][] dp = getDp(charsStr1, charsStr2);

        int end = 0, len = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] > len){
                    len = dp[i][j];
                    end = i;
                }
            }
        }

//        System.out.println(len + " " + end);
        String res = str1.substring(end - len + 1, len + 1);
        return res;
    }

    private int[][] getDp(char[] charsStr1, char[] charsStr2) {
        int m = charsStr1.length;
        int n = charsStr2.length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            dp[i][0] = charsStr1[i] == charsStr2[0] ? 1 : 0;
        }

        for(int i = 0; i < n; i++){
            dp[0][i] = charsStr2[i] == charsStr1[0] ? 1 : 0;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(charsStr1[i] != charsStr2[j])
                    dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp;
    }
}
