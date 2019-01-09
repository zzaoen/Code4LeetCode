package algo.vbase;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 10:57
 * @desc : 小和问题, 归并排序的推广。原本归并排序的merge方法在左右合并过程中可以判断出左边比较小的情况
 * [3, 1, 4, 5, 2]
 * 3左边比3小的数：
 * 1左边比1小的数：
 * 4左边比4小的数：3, 1
 * 5左边比5小的数：3, 1, 4
 * 2左边比2小的数：1
 * 总和即为小和，13
 */
public class N2SmallSum {
    public static void main(String[] args) {

        int[] array = new int[]{3, 1, 4, 5, 2};
        System.out.println(mergeSort(array, 0, array.length - 1));
        return;
    }

    private static int mergeSort(int[] array, int left, int right) {
        if (left == right)
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

        /*while(l1 <= mid && l2 <= right){
            count += array[l1] < array[l2] ? (right-l2+1) * array[l1] : 0;
            helper[helperIndex++] = (array[l1] < array[l2] ? array[l1++] : array[l2++]);
        }*/
        while (l1 <= mid && l2 <= right) {
            if (array[l1] < array[l2]) {
                //考虑左右部分，假设现在左边是1 3 4，右边是2 5，那么比较的时候，左边的1比右边小，所以应该加上两个1；然后2，由于是在右边，不需要计算；接下来是3，但是3只在5左边，所以只需要加上一个3；4同理。
                count += array[l1] * (right - l2 + 1);
                helper[index++] = array[l1++];
            } else {
                helper[index++] = array[l2++];
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
