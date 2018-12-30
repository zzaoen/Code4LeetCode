package algo.bbase.c1_stackqueue;

import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/18 20:46
 * @desc :
 * inStack和outStack分别负责入队和出队，主要问题在出队操作，出队的时候先判断outStack是否为空，如果不为空直接从outStack出栈就可以；
 * 如果outStack为空，那么必须将inStack中所有的值一次加入到outStack。
 */


public class N2TwoStackQueue<T> {

    public Stack<T> inStack = null;
    public Stack<T> outStack = null;

    public N2TwoStackQueue() {
        inStack = new Stack<T>();
        outStack = new Stack<T>();
    }

    public static void main(String[] args) {
        N2TwoStackQueue<Integer> tsqueue = new N2TwoStackQueue<>();
        tsqueue.add(3);
        System.out.println(tsqueue.peek());
        System.out.println(tsqueue.poll());
        tsqueue.add(1);
        System.out.println(tsqueue.poll());
        tsqueue.add(4);
        tsqueue.add(5);
        System.out.println(tsqueue.poll());
        System.out.println(tsqueue.poll());
//        System.out.println(tsqueue.poll());
        return;
    }

    public void add(T value) {
        inStack.push(value);
    }

    public T poll() {
        T res = null;
        if (inStack.isEmpty() && outStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            if(outStack.isEmpty()){
                while(!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
        }
        res = outStack.pop();
        return res;

    }

    public T peek() {
        if(inStack.isEmpty() && outStack.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
        return outStack.peek();
    }
}
