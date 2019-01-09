package algo.vbase.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/11 20:38
 * @desc :
 */
public class N35BinarySearchTree {

    public static void main(String[] args) {
        Node headBalance = Node.initBalance();
        Node headUnBalance = Node.initTree();

        System.out.println(isBinarySearchRecur(headBalance));


        System.out.println(isBinarySearchUnRecur(headBalance));
        System.out.println(isBinarySearchUnRecur(headUnBalance));
        return;
    }

    /*
     * 非递归的中序遍历
     */
    private static boolean isBinarySearchUnRecur(Node head) {
        int preValue = Integer.MIN_VALUE;
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    int curValue = head.value;
                    if(curValue > preValue){
                        preValue = curValue;
                    }else {
                        return false;

                    }
                    head = head.right;
                }
            }
        }

        return true;
    }

    /*
     * 平衡二叉树，左根右是递增的，也就是中序遍历
     */
    private static boolean isBinarySearchRecur(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderRecr(head, list);

        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < list.get(i-1))
                return false;
        }
        return true;
    }

    private static void inOrderRecr(Node head, ArrayList<Integer> list) {
        if(head == null)
            return;
        inOrderRecr(head.left, list);
        list.add(head.value);
        inOrderRecr(head.right, list);
    }
}
