package algo.vbase;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/6/7 16:41
 * @desc : 用递归的方式，得到数组中的最大值。递归的过程中主要是考虑左右两边的比较。
 */
public class GetMaxRecursive {

    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3};
        int[] array = new int[]{2, 4, 9, 0, 3, 5, 6, 7, 1};
//        int[] array = new int[]{5, 4, 3, 2, 1};
        int max = recursiveMax(array, 0, array.length - 1);
        System.out.println(max);

        return;
    }

    private static int recursiveMax(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }
        int mid = left + ((right - left) >> 1);
//        int mid = (left + right) / 2;
        int leftMax = recursiveMax(array, left, mid);
        int rightMax = recursiveMax(array, mid + 1, right);
        return leftMax > rightMax ? leftMax : rightMax;

    }
}
