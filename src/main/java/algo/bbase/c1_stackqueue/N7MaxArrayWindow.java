package algo.bbase.c1_stackqueue;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/10/1 21:29
 * @desc : 给定数组和长度w，长度w的子数组从左移动，记录每次子数组的最大值
 */

/*
4 3 5 4 3 3 6 7
返回
5 5 5 4 6 7
 */
public class N7MaxArrayWindow {

    public static void main(String[] args) {
        int[] arr = new int[]{
                4, 3, 5, 4, 3, 3, 6, 7
        };
        int w = 3;
        int[] res = getMaxWindow(arr, w);
        System.out.println(Arrays.toString(res));
        return;
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if(arr.length < w || arr.length == 0 || w < 1)
            return null;
        int len = arr.length;
        int[] res = new int[len - w + 1];
        int index = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        for(int i = 0; i < len; i++){
            while(!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[i]){
                maxQueue.pollLast();
            }
            maxQueue.addLast(i);

            if(maxQueue.peekFirst() == i-w)
                maxQueue.pollFirst();

            if(i >= w-1)
                res[index++] = arr[maxQueue.peekFirst()];
        }
        return res;
    }


    /*
     * 最坏情况时间复杂度O(N * w)
     */
    public static int[] getMaxWindowSlow(int[] arr, int w){
        if(arr.length < w || arr.length == 0 || w < 1)
            return null;
        int len = arr.length;
        int[] res = new int[len - w + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < w; i++){
            queue.add(arr[i]);
            if(arr[i] > max)
                max = arr[i];
        }
        res[index++] = max;
        for(int i = w; i < len; i++){
            int firstOne = queue.poll();
            if(firstOne == max){ //说明最大值被从队列中移除了，遍历queue得到最大值
                queue.add(arr[i]);
                max = Integer.MIN_VALUE;
                Iterator<Integer> iterator = queue.iterator();
                while (iterator.hasNext()){ //因为这个比较，时间复杂度可能会达到N * w
                    int next = iterator.next();
                    if(next > max)
                        max = next;
                }
            }else {
                if(arr[i] > max)
                    max = arr[i];
                queue.add(arr[i]);
            }
            res[index++] = max;
        }
        return res;
    }
}
