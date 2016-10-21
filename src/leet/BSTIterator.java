package leet;

import leet.TreeNode;

import java.util.Stack;

public class BSTIterator {
    TreeNode node = null;
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        node = root;
    }

    public boolean hasNext() {
        return !( (node==null) && stack.empty() );
    }

    public int next() {
        TreeNode res = null;

        if(node==null) {
            res = stack.pop();
            node = res.right;
        } else {
            while(node.left!=null) {
                stack.push(node);
                node = node.left;
            }
            res = node;
            node = node.right;
        }
        return res.val;
    }
}

