package algo.vbase;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 10:57
 * @desc : 逆序对的个数
 * [4, 3, 5, 2, 1]
 * 4右边比4小的数：3, 2, 1
 * 3右边比3小的数：2, 1
 * 5右边比5小的数：2, 1
 * 2右边比2小的数：1
 * 1右边比1小的数：
 * 总共8对
 */
public class N3InversionCount {

    public static void main(String[] args) {

//        int[] array = new int[]{4, 3, 5, 2, 1};
        int[] array = new int[]{1, 4, 3, 2};
//        int[] array = new int[]{1, 3, 4, 2};
        System.out.println(mergeSort(array, 0, array.length-1));
        System.out.println(Arrays.toString(array));
        return;
    }

    private static int mergeSort(int[] array, int left, int right) {
        if(left == right)
            return 0;
        int mid = left + ((right - left) >> 1);
        return mergeSort(array, left, mid)
                + mergeSort(array, mid + 1, right)
                + merge(array, left, mid, right);
    }

    private static int merge(int[] array, int left, int mid, int right) {
        int count = 0;
        int[] helper = new int[right - left + 1];
        int l1 = left, l2 = mid + 1;
        int index = 0;
        //如果按照从小到大的顺序排列数组的话，假设现在左边部分已排序是3 4 5，右边部分是1 6，那么在合并的过程中按照小和问题的思路，3比1大，但是不能认为3比1之后的数都大。如果按照从大到小的顺序排列，那么左边是5 4 3，右边是6 1，判断5比1大是一个逆序，那么5之后所有的都是相对于1逆序的。
        while(l1 <= mid && l2 <= right){
            if(array[l1] <= array[l2]){ //不符合逆序条件
                helper[index++] = array[l2++];
            } else{ //左边比右边大，那么左边当前位置开始，之后都是符合逆序的
                count += 1 * (right - l2 + 1);
                helper[index++] = array[l1++];
            }
        }

        while(l1 <= mid){
            helper[index++] = array[l1++];
        }

        while(l2 <= right){
            helper[index++] = array[l2++];
        }

        for(int i = 0; i < helper.length; i++){
            array[left + i] = helper[i];
        }
        return count;
    }


}
