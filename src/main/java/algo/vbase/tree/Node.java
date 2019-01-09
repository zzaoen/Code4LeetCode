package algo.vbase.tree;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/11 13:33
 * @desc :
 */
public class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }
/*
  1
 2   3
4  5 6
7 8
*/
    public static Node initTree(){
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        root.left = node2; root.right = node3;
        node2.left = node4; node2.right = node5;
        node3.left = node6;
        node4.left = node7; node4.right = node8;
        node5.left = node9;
        return root;
    }

    public static Node initBalance(){
/*
     5
   3   9
 1    7
*/

        Node root = new Node(5);
        Node node3 = new Node(3);
        Node node1 = new Node(1);
        Node node4 = new Node(4);
        Node node9 = new Node(9);
        Node node7 = new Node(7);

        root.left = node3; root.right = node9;
        node3.left = node1; //node3.right = node4;
        node9.left = node7;
        return root;
    }

    public static void main(String[] args) {

        return;
    }
}
