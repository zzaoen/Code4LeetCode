package algo.vbase;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/5/10 17:05
 * @desc   : 堆排序， 需要知道的是数组元素堆中重建堆的过程
 */
public class N7HeapSort {

    public static void main(String[] args) {
//        int[] array = new int[]{5, 2, 2,2,2,2,2,5, 6,0, 3, 7, 1};
        int[] array = new int[]{5, 2, 1, 6, 3, 7, 0};
        heapSort(array);
//        System.out.println(Arrays.toString(array));
//        int i = (int)(Math.random() * (array.length));
//        array[0] = 0;
//        heapify(array, 0, array.length);

        System.out.println(Arrays.toString(array));
        return;
    }

    //根据数组本身元素的位置，每次插入一个的时候调整相对的位置，建立大根堆
    private static void heapInsert(int[] array, int index) {
        while(array[index] > array[(index-1)/2]){ //这里不能用(index-1)>>1, 当index=0的时候，(0-1)/2 = 0，而（0-1) >> 1 = -1;
            UtilSwap.swapInt(array, index, (index-1)>>1);
            index = (index-1) >> 1;
        }
    }

    //index位置的值发生了变化，重新构建堆
    private static void heapify(int[] array, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest;
            if(left + 1 >= heapSize)
                largest = left;
            else{
                if(array[left] > array[left+1])
                    largest = left;
                else
                    largest = left + 1;
            }
//            largest = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            largest = array[largest] > array[index] ? largest : index;
            if(largest == index)
                break;
            UtilSwap.swapInt(array, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /*
    对排序的过程：大根堆可以得到从小到大的排序，因为每次把最大的值放到最后；同理小根堆正好相反
    大根堆数组的第一个位置一定是堆中最大的值，所以每次把第一个值与最后一个进行交换。交换之后，把最后一个位置的值不考虑在内，对数组进行一次新的heapify操作；然后在将第一个与倒数第二个交换，以此类推。
     */
    private static void heapSort(int[] array) {
        //根据数组得到大根堆
        System.out.println("origin:   " + Arrays.toString(array));
        for(int i = 0; i < array.length; i++){
            heapInsert(array, i);
        }
        System.out.println("big heap: " + Arrays.toString(array));


        int len = array.length;
//        swap(array, 0, --len);
        UtilSwap.swapInt(array, 0, --len);
        System.out.println(Arrays.toString(array));
        while(len > 0){
            heapify(array, 0, len); //传入的len是当前要heapify数组的长度，是数组长，所以heapify内部判断右节点是否越界的时候，要判断>=heapSize
            System.out.println(Arrays.toString(array));
//            swap(array, 0, --len);
            UtilSwap.swapInt(array, 0, --len);
        }


        System.out.println("sorted: " + Arrays.toString(array));

    }



}
