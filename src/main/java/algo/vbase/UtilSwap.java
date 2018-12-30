package algo.vbase;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/6/8 19:19
 * @desc   : 帮助数组进行交换的工具类
 */
public class UtilSwap {

    public static void main(String[] args) {

        return;
    }

    public static void swapInt(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //如果array中交换的包含0，那么这个方法就GG了
    public static void swapIntPositive(int[] array, int i, int j) {
         array[i] = array[i] ^ array[j];
         array[j] = array[i] ^ array[j];
         array[i] = array[i] ^ array[j];
    }

}
