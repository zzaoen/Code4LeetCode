package algo.vbase.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/8/11 20:38
 * @desc   :
 */
public class N34BalanceTree {

    public static void main(String[] args) {
        Node headBalance = Node.initBalance();

        System.out.println(isBalance(headBalance));


        /*Node head = Node.initTree();
        System.out.println(getDepth(head));*/

        return;
    }


    /*
     * 是从根节点的左右孩子开始，一个一个向下判断，一个节点被计算多次
     */
    private static boolean isBalance(Node head) {
        if(head == null){
            return true;
        }
        if(Math.abs(getDepth(head.left) - getDepth(head.right)) <= 1){
            return (isBalance(head.left)) && (isBalance(head.right));
        } else{
            return false;
        }
    }

    private static int getDepth(Node head) {
        if(head == null)
            return 0;
        int leftH = getDepth(head.left);
        int rightH = getDepth(head.right);
        return Math.max(leftH, rightH) + 1;
    }


}
