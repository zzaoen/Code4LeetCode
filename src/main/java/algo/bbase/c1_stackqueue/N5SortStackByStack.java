package algo.bbase.c1_stackqueue;

import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/18 21:30
 * @desc : 对一个栈进行排序，从顶到底按从大到小排序，只能借助一个额外的栈，额外的栈需要实现从顶到底按照从小到大的顺序才行。
 *
 */
public class N5SortStackByStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(7);
        stack.push(4);
        stack.push(3);

        while (!stack.isEmpty()){
            int cur = stack.pop();
            /*if(helper.isEmpty() || cur <= helper.peek()){
                helper.push(cur);
            } else{
                while(!helper.isEmpty()){
                    stackqueue.push(helper.pop());
                }
                helper.push(cur);
            }*/

            //简单点的方式
            //其实是没有深入研究问题的条件，这里只有在helper不为空而且cur比helper的顶部大的时候，需要将helper中小于cur的值转移到stack中
            //而其他的情况都是直接把cur放入helper中，比如helper为空
            while(!helper.isEmpty() && cur > helper.peek()){
                stack.push(helper.pop());
            }
            helper.push(cur);

        }



        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }


        return;
    }
}
