package leetcode.complexity;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/10/2 18:27
 * @desc : 重点是考虑反转后溢出情况以及结尾的0，所以不能简单的当做字符串来做。
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
        return;
    }

    public static int reverse(int x) {
        int res = 0;
        int left = 0;
        while(x != 0){
            left = x % 10;
            x = x / 10;
            res = res * 10 + left;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }
        return res;
    }
}
