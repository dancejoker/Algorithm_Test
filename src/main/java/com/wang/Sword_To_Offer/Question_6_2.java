package com.wang.Sword_To_Offer;

import java.util.Arrays;

/**
 * Created by ddp on 2018/3/4.
 */
public class Question_6_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

        public TreeNode reConstructBinaryTree(int[] pre, int[] in) throws Exception {
            if (pre == null || in == null)
                return null;
            if (pre.length != in.length)
                throw new Exception("illegal input");
            if(pre.length == 0)
                return null;
            TreeNode root = new TreeNode(pre[0]);
            for (int i = 0; i < in.length; ++i) {
                if (in[i] == pre[0]) {
                    root.val = in[i];
                    root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                    root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                }
            }
            return root;
        }

    public static void main(String[] args) throws Exception {
        int[] preSort={1,2,3,4,5,6,7};
        int[] inSort={3,2,4,1,6,5,7};
        TreeNode root= new Question_6_2().reConstructBinaryTree(preSort,inSort);
    }
}
