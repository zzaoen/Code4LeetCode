package algo.vbase.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/11 21:16
 * @desc :
 */
public class N36CompleteBinaryTree {

    public static void main(String[] args) {
        Node headIs = Node.initBalance();
        System.out.println(isCBT(headIs));
        return;
    }

    /*
     * 层序遍历的方式
     * 如果到某个节点，它只有左孩子，没有右孩子，那么接下来一层都只能是叶子节点
     * 如果到某个节点，
     */
    private static boolean isCBT(Node head) {
        if (head != null) {
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(head);
            boolean startLeaf = false;
            Node node = null;
            while(!queue.isEmpty()){
                node = queue.poll();
//                System.out.println(node.value);
                if(startLeaf && (node.left != null || node.right != null)){
                    return false;
                }
                if(node.left != null && node.right == null){
                    startLeaf = true;
                }
                if(node.left == null && node.right != null){
                    return false;
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return true;
    }
}
