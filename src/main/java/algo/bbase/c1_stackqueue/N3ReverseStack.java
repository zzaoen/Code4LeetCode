package algo.bbase.c1_stackqueue;

import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/8/18 20:59
 * @desc   : 使用递归的方式逆序一个栈
 */
public class N3ReverseStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        /*reverseFailed(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);*/

        reverseSucceed(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        return;
    }
    /*
     * 这种方式得到的结果和原始的一样，比如开始的栈从顶到底是5 4 3 2 1，那么这个递归到栈中只有一个值时结束，执行stack.add()，结果第一个插入到栈的是1，然后插入2...等于没有做。
     * 所以现在的问题是int i = stack.pop()这句，这个i应该得到当前栈底的值才可以。
     */
    public static void reverseFailed(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = stack.pop();
        reverseFailed(stack);
        stack.add(i);
    }

    /*
     * 当前栈从顶到底是5 4 3 2 1，因为每次的getAndRemoveBottom得到的是栈底值，所以最后一次得到的是5，然后插入；然后是4，所以得到的栈变成1 2 3 4 5
     */
    public static void reverseSucceed(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveBottom(stack);
        reverseSucceed(stack);
        stack.add(i);
    }


    //拿到并删除当前的栈底
    private static int getAndRemoveBottom(Stack<Integer> stack) {
        int res = stack.pop();
        if(stack.isEmpty()){
            return res;
        }else {
            int last = getAndRemoveBottom(stack);
            stack.add(res);
            return last;
        }
    }
}
