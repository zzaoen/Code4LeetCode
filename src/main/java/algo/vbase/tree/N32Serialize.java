package algo.vbase.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/11 19:17
 * @desc :
 */
public class N32Serialize {

    public static void main(String[] args) {

        Node head = Node.initTree();

        String strTree = serialize(head);
        System.out.println(strTree);

        strTree = serialize2(head);
        System.out.println(strTree);


        /* error
        head = deserialize(strTree);
        N31TraverseLevel.levelTraverse(head);*/


        head = deserialize2(strTree);
        N31TraverseLevel.levelTraverse(head);

        return;
    }

    private static Node deserialize2(String strTree) {
        String[] split = strTree.split("!");
        Queue<String> queue = new LinkedList<String>();
        for(String s : split){
            queue.add(s);
        }
        return deserializeRecr(queue);
    }

    private static Node deserializeRecr(Queue<String> queue) {
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = deserializeRecr(queue);
        head.right = deserializeRecr(queue);
        return head;
    }


    private static Node deserialize(String strTree) {
        String[] split = strTree.split("!");
        Stack<Node> stack = new Stack<>();
        Node head = new Node(Integer.parseInt(split[0]));
        Node headBack = head;
        stack.add(head);
        for (int i = 1; i < split.length; i++) {
            if ("#".equals(split[i])) {
                if(i == split.length - 1){
                    break;
                }else if("#".equals(split[++i])){
                    stack.pop();
                }
            } else {

                head = stack.peek();
                if(head.left != null)
                    stack.pop();

                int value = Integer.parseInt(split[i]);
                Node node = new Node(value);
                if(head.left == null){
                    head.left = node;
                    stack.add(node);
                }else{
                    head.right = node;
                    stack.add(node);
                }
            }
        }

        return headBack;
    }

    /*
     * 先序遍历序列化树
     * 根右左的顺序加入栈
     */
    private static String serialize(Node head) {
        StringBuilder sb = new StringBuilder();

        if (head != null) {
            Node node = null;
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (node == null) {
                    sb.append("#!");
                } else {
                    sb.append(node.value + "!");
//                if(node.right != null)
                    stack.push(node.right);
//                if(node.left != null)
                    stack.push(node.left);
                }
            }

        }
        return sb.toString();
    }

    /*
     * 先序遍历序列化树
     * 递归的方式
     */
    private static String serialize2(Node head) {
        if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialize2(head.left);
		res += serialize2(head.right);
		return res;
    }
}
