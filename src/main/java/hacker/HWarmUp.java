package hacker;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 1/7/19 8:35 PM
 * @desc :
 */
public class HWarmUp {

    public static void main(String[] args) {
//        countingValleys(8, "UDDUDUDU");
//        countingValleys(8, "UDDDUDUU");

//        sockMerchant(5, new int[]{1, 2, 1, 3, 2});

//        jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0});

//        repeatedString("aaa", 100000);

        return;
    }

    static int countingValleys(int n, String s) {
        int res = 0;
        int position = 0;
        boolean isJudgeStart = true;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if ('U' == c) { //up
                position += 1;
                if(position == 0){ // up and then == 0, means it's a valley
                    res += 1;
                }
            } else {//down
                position -= 1;
            }
        }
//        System.out.println(res);
        return res;
    }

    static int sockMerchant(int n, int[] ar) {
        int count = 0;
        if (n <= 1) {
            return count;
        }
        int[] counter = new int[101];
        for (int i : ar) {
            counter[i]++;
        }


        for (int i = 1; i < counter.length; i++) {
            if (counter[i] >= 2) {
                count += counter[i] / 2;
            }
        }
        System.out.println(count);
        return count;

    }

    static int jumpingOnClouds(int[] c) {
        int count = 0;
        for (int i = 0; i < c.length; ) {
            if (i + 2 < c.length && c[i + 2] == 1) {
                i += 1;
            } else if (i + 1 < c.length) {
                i += 2;
            }
            count++;
            if (i >= c.length - 1)
                break;
        }
//        System.out.println(count);
        return count;
    }

    static long repeatedString(String s, long n) {
        long res = 0;

        int aTime = 0;
        int index = 0, lIndex = 0;

        while ((lIndex = s.indexOf("a", index)) != -1) {
            index = lIndex + 1;
            aTime++;
        }

        int len = s.length();
        if (aTime == 0)
            return 0;
        if (aTime == len)
            return n;

//        System.out.println(aTime);


        long quotient = n / len;
        long remainder = n % len;
//        System.out.println(aTime + " " + quotient + "  " + remainder);

        int moreTime = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < remainder; i++) {
            if ('a' == chars[i])
                moreTime++;
        }
        res = quotient * aTime + moreTime;
        System.out.println(res);
        return res;
    }



}
