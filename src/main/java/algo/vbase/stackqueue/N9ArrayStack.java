package algo.vbase.stackqueue;


import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/15 19:27
 * @desc : 数组实现的栈，长度固定
 */
public class N9ArrayStack<T> {

    private int stackSize;
    private T[] stack;
    private int index;
    public N9ArrayStack(int stackSize){
        this.stackSize = stackSize;
        stack = (T[]) new Object[stackSize];
        index = 0;
    }

    public boolean empty(){
        if(index == 0)
            return true;
        else
            return false;
    }

    public boolean full(){
        if(index == stackSize)
            return true;
        else
            return false;
    }

    public void push(T value){
        if(full()){
            throw new ArrayIndexOutOfBoundsException("Stack full");
        }else{
            stack[index++] = value;
        }

    }
    public T pop(){
        if(empty()){
            throw new ArrayIndexOutOfBoundsException("Stack Empty");
        }else{
            return stack[--index];
        }
    }

    public static void main(String[] args) {
        N9ArrayStack stack = new N9ArrayStack(5);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            System.out.println(Arrays.toString(stack.stack));
            stack.push(6);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        }catch (ArrayIndexOutOfBoundsException e){

        }
        return;
    }
}
