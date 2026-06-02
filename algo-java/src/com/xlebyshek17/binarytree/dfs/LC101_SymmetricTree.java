package com.xlebyshek17.binarytree.dfs;

import com.xlebyshek17.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC101_SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root.left == null && root.right == null) return true;

        if(root.left == null || root.right == null) return false;

        stack.addFirst(root.left);
        stack.addFirst(root.right);

        while (!stack.isEmpty()) {
            TreeNode right = stack.pollFirst();
            TreeNode left = stack.pollFirst();

            if (left.val != right.val) {
                return false;
            }

            if (left.left != null && right.right != null) {
                stack.addFirst(left.left);
                stack.addFirst(right.right);
            } else if (left.left != null || right.right != null) {
                return false;
            }

            if (left.right != null && right.left != null) {
                stack.addFirst(left.right);
                stack.addFirst(right.left);
            } else if (left.right != null || right.left != null) {
                return false;
            }
        }

        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    static void main() {
        // [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
