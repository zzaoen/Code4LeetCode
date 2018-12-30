package algo.vbase.stackqueue;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/15 20:04
 * @desc : 可以拿到最大值的栈
 */
public class N10GetMaxStack {

    private int stackSize;
    private int[] stack;
    private int[] maxStack;
    private int index;
    public N10GetMaxStack(int stackSize){
        this.stackSize = stackSize;
        stack = new int[stackSize];
        maxStack = new int[stackSize];
        index = 0;
    }


    public void push(int value){
        if(index == stackSize){
            throw new ArrayIndexOutOfBoundsException("Stack full");
        }else{
            if(index == 0){ //第一次入栈
                stack[index] = value;
                maxStack[index] = value;
                index++;
            }else{
                int max = maxStack[index-1];
                stack[index] = value;
                maxStack[index] = (max > value ? max : value);
                index++;
            }

        }

    }
    public int pop(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("Stack Empty");
        }else{

            return stack[--index];
        }
    }

    public int peek(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("Stack Empty");
        }
        return maxStack[index-1];
    }

    public int currentMax(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("Stack Empty");
        }
        return maxStack[index-1];
    }

    public static void main(String[] args) {
        /*N10GetMaxStack stackqueue = new N10GetMaxStack(10);
        stackqueue.push(1);
        stackqueue.push(10);
        stackqueue.push(5);
        stackqueue.push(7);
        stackqueue.push(20);

        System.out.println(stackqueue.currentMax());

        System.out.println(stackqueue.popMin() + " max: " + stackqueue.currentMax());
        System.out.println(stackqueue.popMin() + " max: " + stackqueue.currentMax());
        System.out.println(stackqueue.popMin() + " max: " + stackqueue.currentMax());
        System.out.println(stackqueue.popMin() + " max: " + stackqueue.currentMax());
        System.out.println(stackqueue.popMin() + " max: " + stackqueue.currentMax());*/

        N10GetMaxStack stack1 = new N10GetMaxStack(10);
		stack1.push(3);
		System.out.println(stack1.currentMax());
		stack1.push(4);
		System.out.println(stack1.currentMax());
		stack1.push(1);
		System.out.println(stack1.currentMax());

		System.out.println(stack1.pop());
		System.out.println(stack1.currentMax());

		System.out.println("=============");

		N10GetMaxStack stack2 = new N10GetMaxStack(10);
		stack2.push(4);
		System.out.println(stack2.currentMax());
		stack2.push(3);
		System.out.println(stack2.currentMax());
		stack2.push(1);
		System.out.println(stack2.currentMax());
		System.out.println(stack2.pop());
		System.out.println(stack2.currentMax());


        return;
    }
}
