package algo.vbase;
import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/6/7 16:57
 * @desc : merge排序，在左右两边处理完之后，需要一个合并左右两边的操作
 * 空间复杂度O(n)，因为每一步的merge需要用一个辅助的数组，虽然每一步都有辅助数组，但是完全可以复用一个数组，数组的长度就是原来的长度，所以空间复杂度就是O(n)
 */
public class N1MergeSort {

    public static void main(String[] args) {

        int[] array = new int[]{4, 2, 9, 1, 0, 8, 5, 3};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        return;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if(left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //左边部分：left 到 mid
        //右边部分：mid+1 到 right
        int[] helper = new int[right - left + 1];
        int l1 = left;
        int l2 = mid + 1;
        int index = 0;

        while (l1 <= mid && l2 <= right) {
            helper[index++] = (array[l1] < array[l2] ? array[l1++] : array[l2++]);
        }

        while (l1 <= mid) {
            helper[index++] = array[l1++];
        }

        while (l2 <= right) {
            helper[index++] = array[l2++];
        }

        for (int i = 0; i < helper.length; i++) {
            array[left + i] = helper[i];
        }
    }
}
