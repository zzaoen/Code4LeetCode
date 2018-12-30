package algo.vbase;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/5/10 16:18
 * @desc   : 快速排序，低效率的版本
 */
public class N5QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 9, 1, 0, 8, 5, 2, 5, 2};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        return;
    }

    /*
    这个版本的快速排序有一个很大的问题在partition部分。
    partition函数的主要功能是以一个值为轴，从右边开始，把小于pivot放左边，把大于pivot的放右边。虽然在情况好的时候，每次可以把左右两部分做到相对的区分大小，但是这个函数还是一次只确定的一个值的位置，就是pivot。
     */
    private static void quickSort(int[] array, int left, int right) {
        if(left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        while(left < right){
            while(left < right && array[right] >= pivot) right--;
            array[left] = array[right];

            while(left < right && array[left] < pivot) left++;
            array[right] = array[left];

        }
        array[left] = pivot;
        return left;
    }










    
}
