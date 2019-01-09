package leetcode.tree;

import leetcode.common.TreeNode;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/10/2 18:01
 * @desc :
 */
public class MaxDepth {

    public static void main(String[] args) {

        return;
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth, rDepth) + 1;
    }
}
