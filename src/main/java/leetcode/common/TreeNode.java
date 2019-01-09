package leetcode.common;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/11 13:33
 * @desc :
 */
public class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
/*
  1
 2   3
4  5 6
7 8
*/
    public static TreeNode initTreeNode(){
        TreeNode root = new TreeNode(1);
        TreeNode TreeNode2 = new TreeNode(2);
        TreeNode TreeNode3 = new TreeNode(3);
        TreeNode TreeNode4 = new TreeNode(4);
        TreeNode TreeNode5 = new TreeNode(5);
        TreeNode TreeNode6 = new TreeNode(6);
        TreeNode TreeNode7 = new TreeNode(7);
        TreeNode TreeNode8 = new TreeNode(8);
        TreeNode TreeNode9 = new TreeNode(9);

        root.left = TreeNode2; root.right = TreeNode3;
        TreeNode2.left = TreeNode4; TreeNode2.right = TreeNode5;
        TreeNode3.left = TreeNode6;
        TreeNode4.left = TreeNode7; TreeNode4.right = TreeNode8;
        TreeNode5.left = TreeNode9;
        return root;
    }

    public static TreeNode initBalance(){
/*
     5
   3   9
 1    7
*/

        TreeNode root = new TreeNode(5);
        TreeNode TreeNode3 = new TreeNode(3);
        TreeNode TreeNode1 = new TreeNode(1);
        TreeNode TreeNode4 = new TreeNode(4);
        TreeNode TreeNode9 = new TreeNode(9);
        TreeNode TreeNode7 = new TreeNode(7);

        root.left = TreeNode3; root.right = TreeNode9;
        TreeNode3.left = TreeNode1; //TreeNode3.right = TreeNode4;
        TreeNode9.left = TreeNode7;
        return root;
    }

    public static void main(String[] args) {

        return;
    }
}
