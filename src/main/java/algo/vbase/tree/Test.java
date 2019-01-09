package algo.vbase.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/11 18:41
 * @desc :
 */
public class Test {

    public static void main(String[] args) {
        Node head = Node.initTree();
        levelTraverse(head);
        return;
    }

    private static void levelTraverse(Node head) {
        Node last = head;
        Node nlast = null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(head);
        while(!queue.isEmpty()){

            Node node = queue.poll();
            System.out.print(node.value);
            if(node.left != null){
                queue.add(node.left);
                nlast = node.left;
            }
            if(node.right != null){
                queue.add(node.right);
                nlast = node.right;
            }
            if(node == last){
                System.out.println();
                last = nlast;
            }

        }
    }
}
