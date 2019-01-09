package algo.vbase;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 15:20
 * @desc : 快速排序，优化版，每次把相同的值放在中间；传统的快排每次只搞定一个值。
 * 空间复杂度为logN，因为每次要记录中间点的位置。实际上在最坏的情况下，递归要N层，所以空间复杂度最坏是N
 */
public class N6QuickSortAdvanced {

    public static void main(String[] args) {

        int[] array = new int[]{4, 2, 9, 1, 0, 8, 5, 2, 5, 2};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        return;
    }

    /*
    partition函数返回的是一个int[2]的数组，意味着如果选择的pivot在数组中存在多个，那么这一次partition操作返回的数组分别标记了整理后pivot所在的位置开始和结束的索引值
     */
    private static void quickSort(int[] array, int left, int right){
        if(left < right) {
            //为了避免数组有序，每次去最后一个位置的值造成排序最差的情况，可以采用随机数办法，将最后一个值替换成前面随机的一个值
            //swap(array, right, left+(int)(Math.random()*(right-left+1)));

            int[] pivotIndexs = partition(array, left, right);
            quickSort(array, left, pivotIndexs[0] - 1);
            quickSort(array, pivotIndexs[1] + 1, right);
        }
    }

    private static int[] partition(int[] array, int left, int right) {
        int[] res = new int[2];
        int lessIndex = left - 1;
        int moreIndex = right;
        int pivot = array[right];
        //和最右边的值比较，最后一个值作为中间值，最后要放到中间位置，也就是下面的swap(array, moreIndex, right);语句
        while(left < moreIndex){
            if(array[left] < pivot){
                swap(array, ++lessIndex, left++);
            }else if(array[left] > pivot){
                swap(array, --moreIndex, left);
            }else {
                left++;
            }
        }
        swap(array, moreIndex, right);
        res[0] = lessIndex + 1;
        res[1] = moreIndex;

        return res;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
