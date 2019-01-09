package leetcode.array;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/10/2 18:20
 * @desc :
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] array = new int[]{1,1,2,2,3,4,4};
        System.out.println(singleNumber(array));
        return;
    }

    public static int singleNumber(int[] A) {
        int res = 0;
        for(int x : A){
            res ^= x;
        }
        return res;
    }
}
