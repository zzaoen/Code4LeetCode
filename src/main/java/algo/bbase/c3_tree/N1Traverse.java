package algo.bbase.c3_tree;

import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/11 13:30
 * @desc :
 */
public class N1Traverse {

    public static void main(String[] args) {
        Node head = Node.initTree();

        //前序 根左右
        preOrderRecr(head);
        System.out.println();

        inOrderRecr(head);
        System.out.println();

        postOrderRecr(head);
        System.out.println();
        System.out.println();


        preOrderUnRecur(head);
        inOrderUnRecr(head);
        postOrderUnRecur(head);


        /*head = Node.initBalance();
        inOrderRecr(head);*/

        return;
    }

    private static void inOrderUnRecr(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value);
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /*
     * 左右根
     * 按照前序遍历的方式：根右左对树遍历，结果存放在stack中，最后依次出栈得到的就是左右根的顺序了
     */
    private static void postOrderUnRecur(Node root) {

        if (root != null) {
            Stack<Node> stackNode = new Stack<>();
            Stack<Integer> stackVale = new Stack<>();
            stackNode.push(root);
            while (!stackNode.isEmpty()) {
                Node node = stackNode.pop();
                stackVale.push(node.value);
                if (node.left != null)
                    stackNode.add(node.left);
                if (node.right != null)
                    stackNode.add(node.right);
            }

            while (!stackVale.isEmpty()) {
                System.out.print(stackVale.pop());
            }
        }
        System.out.println();
    }


    /*
     * 根左右
     * 借助stack，先输出自己，然后先压入右边，在压入左边，这样输出的时候，就可以保证根左右顺序了
     */
    private static void preOrderUnRecur(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.value);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);

            }
        }
        System.out.println();

    }

    private static void postOrderRecr(Node root) {
        if (root == null)
            return;
        postOrderRecr(root.left);
        postOrderRecr(root.right);
        System.out.print(root.value);
    }

    private static void inOrderRecr(Node root) {
        if (root == null)
            return;
        inOrderRecr(root.left);
        System.out.print(root.value);
        inOrderRecr(root.right);
    }

    private static void preOrderRecr(Node root) {
        if (root == null)
            return;
        System.out.print(root.value);
        preOrderRecr(root.left);
        preOrderRecr(root.right);

    }


}
