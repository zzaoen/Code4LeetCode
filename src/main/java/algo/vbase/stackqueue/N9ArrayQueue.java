package algo.vbase.stackqueue;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/15 19:37
 * @desc : 数组实现的队列，长度固定
 */
public class N9ArrayQueue {

    private int left;
    private int right;
    private int size;
    private int queueSize;
    private int[] queue;

    public N9ArrayQueue(int queueSize){
        queue = new int[queueSize];
        this.queueSize = queueSize;
        left  = 0;
        right = 0;
        size = 0;
    }

    public void enque(int value){
        if(size == queueSize){
            throw new ArrayIndexOutOfBoundsException("Queue full");
        }
        queue[right] = value;
        right = right == queueSize-1 ? 0 : right + 1;
        size++;
    }

    public int deque(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("Queue empty");
        }
        size--;
        int tmp = left;
        left = left == queueSize-1 ? 0 : left + 1;
        return queue[tmp];
    }

    public int peek(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("Queue empty");
        }
        return queue[left];

    }

    public static void main(String[] args) {
        N9ArrayQueue queue = new N9ArrayQueue(5);
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
        System.out.println(Arrays.toString(queue.queue));
//        queue.enque(6);
        System.out.println(queue.peek());
        System.out.println(queue.peek());

        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
//        System.out.println(queue.deque());
        return;
    }
}
