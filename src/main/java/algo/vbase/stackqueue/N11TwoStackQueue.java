package algo.vbase.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/15 20:24
 * @desc : 两个栈实现队列
 * 比如知道广度优先算法是使用队列的，要求使用栈实现广度优先，那么就可以把栈封装一下，当做队列使用
 */
public class N11TwoStackQueue {

    private Deque<Integer> stackPush;
    private Deque<Integer> stackPop;

    public N11TwoStackQueue(){
        stackPush = new ArrayDeque<>();
        stackPop = new ArrayDeque<>();
    }

    public void enque(int value){
        stackPush.push(value);
    }

    public int deque(){
        if(stackPop.size() != 0){
            return stackPop.pop();
        }else{
            if(stackPush.size() == 0){
                throw new ArrayIndexOutOfBoundsException("Empty Queue");
            }else {
                while(stackPush.size() > 0){
                    stackPop.push(stackPush.pop());
                }
                return stackPop.pop();
            }
        }
    }

    public static void main(String[] args) {
        N11TwoStackQueue queue = new N11TwoStackQueue();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        System.out.println(queue.deque());
        System.out.println(queue.deque());
//        System.out.println(queue.deque());
//        System.out.println(queue.deque());
        queue.enque(4);
        queue.enque(5);
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        return;
    }
}
