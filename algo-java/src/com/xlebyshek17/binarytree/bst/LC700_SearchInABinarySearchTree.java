package com.xlebyshek17.binarytree.bst;

import com.xlebyshek17.binarytree.TreeNode;

public class LC700_SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (val > root.val) return searchBST(root.right, val);

        return searchBST(root.left, val);
    }
}
