package algo.vbase;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 14:42
 * @desc : 分成左右两部分，左侧小于pivot，右侧大于pivot; 荷兰国旗问题
 */
public class N4SeparateArray {

    public static void main(String[] args) {


        int[] array1 = {4, 5, 9, 1, 0, 8, 5, 2};
        System.out.println(Arrays.toString(array1) + "\n************************************");


//        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
//        separateByExchangeBiggerToTail(array1, 5);
//        System.out.println(Arrays.toString(array1));


        int[] array2 = {4, 3, 9, 1, 0, 8, 5, 2};
        separateByMoveSmallerToHead(array2, 5);
        System.out.println(Arrays.toString(array2));
        //[4, 2, 1, 0, 2, 8, 5, 9], 如果pivot在数组中，那么不能很好的处理。

        int[] array3 = {4, 3, 9, 1, 0, 8, 5, 10}; //[4, 2, 2, 1, 0, 5, 8, 9]
        separateBothSide(array3, 5);
        System.out.println(Arrays.toString(array3));
        return;
    }


    /*
    从左向右开始，每次遇到比key大的值，将其与最后一位交换。
    所以只需要注意每次交换后需要记录当前最后一位所在的索引值。
    但是这个方法也很不好，因为如果是1 2 3 4 5 6 7这种排好序的数组，从3开始，每次都和最后的位置交换值
     */
    private static void separateByExchangeBiggerToTail(int[] array1, int key) {
        int biggerIndex = array1.length - 1;
        int i = 0;
        while (i < biggerIndex) {
            if (array1[i] > key) {
                UtilSwap.swapInt(array1, i, biggerIndex--);
            } else {
                i++;
            }

        }
    }

    /*
    遍历数组，把比key小的值，移动到前面的位置来。
    是要让数组的前半区是小于key的值，要记录前半区移动的索引情况。
     */
    private static void separateByMoveSmallerToHead(int[] array2, int key) {
        int lessIndex = -1;
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] < key) {
                if (array2[lessIndex + 1] != array2[i]) {
                    UtilSwap.swapInt(array2, lessIndex + 1, i);
                }
                lessIndex++;
            }

        }
    }


    /*
    在上一个方法的基础上，不仅把小的往前移，而且把大的往后移
     */
    private static void separateBothSide(int[] array3, int key) {
        int lessIndex = -1, moreIndex = array3.length;
        for(int i = 0; i < moreIndex; i++){
            if(array3[i] < key){ //左边的移动过程
                if(array3[lessIndex + 1] != array3[i]){
                    UtilSwap.swapInt(array3, lessIndex + 1, i);
                }
                lessIndex++;
            } else if(array3[i] > key){
                /*if(array3[moreIndex - 1] != array3[i]){
                    UtilSwap.swapInt(array3, moreIndex - 1, i);
                }*/
                UtilSwap.swapInt(array3, moreIndex - 1, i);
                moreIndex--;
                i--;
            } else{
                continue;
            }
        }
    }






    /*private static void separate1(int[] array, int pivot) {
        int lessIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {
                if (array[lessIndex + 1] != array[i]) {
                    int tmp = array[lessIndex + 1];
                    array[lessIndex + 1] = array[i];
                    array[i] = tmp;
                }
                lessIndex++;
            }
        }
    }

    private static void separate2(int[] array, int pivot) {
        int lessIndex = -1;
        int moreIndex = array.length;
        for (int i = 0; i < moreIndex; i++) {
            if (array[i] < pivot) {
                if (array[lessIndex + 1] != array[i]) {
                    int tmp = array[lessIndex + 1];
                    array[lessIndex + 1] = array[i];
                    array[i] = tmp;
                }
                lessIndex++;
            } else if (array[i] > pivot) {
                int tmp = array[moreIndex - 1];
                array[moreIndex - 1] = array[i];
                array[i] = tmp;
                moreIndex--;
                i--;
            } else {
                continue;
            }
        }
    }*/
}
