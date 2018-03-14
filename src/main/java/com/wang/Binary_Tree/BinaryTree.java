package com.wang.Binary_Tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉排序树
 * Created by ddp on 2018/2/24.
 */
public class BinaryTree {
    private Node root = null;

    BinaryTree(int value) {
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }

    /**
     * 查找二叉树中的节点
     *
     * @param value
     * @return 找到节点则返回节点否则返回空
     * @throws
     */
    public Node findKey(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.getValue())
                return current;
            else if (value < current.getValue())
                current = current.getLeftChild();
            else if (value > current.getValue())
                current = current.getRightChild();
        }
        return current;
    }

    /**
     * 将数据插入二叉树
     *
     * @param value
     * @return 返回插入情况，若空则成功，否则失败
     * @throws
     */
    public String insert(int value) {
        String error = null;
        Node node = new Node(value);
        if (root == null) {
            root = node;
            root.setLeftChild(null);
            root.setRightChild(null);
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                if (value < current.getValue()) {
                    parent = current;
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(node);
                        break;
                    }
                } else if (value > current.getValue()) {
                    parent = current;
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(current);
                        break;
                    }
                } else {
                    error = "having same value in binary tree";
                    break;
                }
            }
        }
        return error;
    }

    /**
     * 中序遍历(递归)
     *
     * @param
     * @return 空
     * @throws
     */
    public void inOrderTraverse() {
        System.out.print("中序遍历:");
        inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node node) {
        if (node == null)
            return;

        inOrderTraverse(node.leftChild);
        System.out.print(node.getValue() + '\t');
        inOrderTraverse(node.rightChild);
    }

    /**
     * 中序非递归遍历：
     *
     * @param
     * @return
     * @throws
     */
    public void inOrderByStack() {
        System.out.print("中序非递归遍历:");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeftChild();
            }
            if(!stack.isEmpty()){
                current = stack.pop();
                System.out.println(current.getValue());
                current = current.getRightChild();
            }
        }
        System.out.println();
    }

    /**
     * 前序遍历
     * @param
     * @return
     * @throws
     */
    public void preOrderTraverse() {
        System.out.print("前序遍历:");
        preOrderTraverse(root);
        System.out.println();
    }
    private void preOrderTraverse(Node node) {
        if (node == null)
            return ;
        System.out.print(node.getValue() + '\t');
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 前序非递归遍历
     * @param
     * @return
     * @throws
     */
    public void preOrderByStack(){
        System.out.print("前序非递归遍历:");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while(current != null || !stack.isEmpty()){
            while (current != null){
                System.out.print(current.getValue() + "\t");
                stack.push(current);
                current = current.getLeftChild();
            }
            while (!stack.isEmpty()){
               current =  stack.pop();
               current = current.getRightChild();
            }
        }
        System.out.println();
    }

    /**
     * 得到最小(大)值：依次向左(右)直到空为之
     * @param
     * @return
     * @throws
     */
    public int getMinValue() throws Exception {
        if(root == null)
            throw new Exception("树为空");
        Node current = root;
        while(current != null){
            current = current.getLeftChild();
        }
        return current.getValue();
    }


    /**
     * 层次遍历
     * @param root
     */
    public static void levelRead(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>() ;
        queue.add(root);
        while(queue.size() != 0) {
            int len = queue.size();
            for(int i=0;i <len; i++) {
                Node temp = queue.poll();
                System.out.print(temp.getValue()+" ");
                if(temp.getLeftChild() != null)  queue.add(temp.getLeftChild());
                if(temp.getRightChild() != null) queue.add(temp.getRightChild());
            }
        }
    }


    /**
     * 二叉树深度
     */
     public static int getMaxDepth(Node root){
         if(root == null)
             return  0;
         else {
             int left = getMaxDepth(root.getLeftChild());
             int right = getMaxDepth(root.getRightChild());
             return 1 + Math.max(left,right);
         }
     }

    /**
     * 二叉树宽度
     */
    public static int getMaxWidth(Node root){
        if(root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        int maxWidth = 1;
        queue.add(root);
        while(true){
            int len = queue.size(); //当前层的节点个数
            if(len == 0)
                break;
            while(len > 0){ // 如果当前层，还有节点
                Node t = queue.poll();
                len--;
                if (t.getLeftChild() != null)
                    queue.add(t.getLeftChild());
                if (t.getRightChild() != null)
                    queue.add(t.getRightChild());
            }
            maxWidth = Math.max(maxWidth, queue.size());
        }
        return maxWidth;
    }

    /**
     * 获取叶子节点的个数
     */
    public static int getNumOfLeaf(Node root){
        if(root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(queue.size() != 0){
            int size = queue.size();
            for(int i = 0;i < size;++i){
                Node node = queue.poll();
                if(node.getRightChild() == null && node.getLeftChild() == null){
                    count ++;
                }else {
                    if(node.getLeftChild() != null)
                        queue.add(node.getLeftChild());
                    if(node.getRightChild() != null)
                        queue.add(node.getRightChild());
                }
            }
        }
        return count;
    }


    /**
     *  删除节点
     *  1.删除节点为叶子节点
     *  2.删除节点只有一个子节点：只有一个左子节点或只有一个右子节点
     *  3.删除节点有两个子节点：这种情况比较复杂，需要寻找后继节点，
     *  即比要删除的节点的关键值次高的节点是它的后继节点。
     *
     * @param value
     * @return
     * @throws
     */
    public boolean delete(int value) {
        Node current = root;    //需要删除的节点
        Node parent = null;     //需要删除的节点的父节点
        boolean isLeftChild = true;   //需要删除的节点是否父节点的左子树

        while (true) {
            if (value == current.getValue()) {
                break;
            } else if (value < current.getValue()) {
                isLeftChild = true;
                parent = current;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                parent = current;
                current = current.rightChild;
            }

            //找不到需要删除的节点,直接返回
            if (current == null)
                return false;
        }

        //分情况考虑
        //1、需要删除的节点为叶子节点
        if (current.leftChild == null && current.rightChild == null) {
            //如果该叶节点为根节点，将根节点置为null
            if (current == root) {
                root = null;
            } else {
                //如果该叶节点是父节点的左子节点，将父节点的左子节点置为null
                if (isLeftChild) {
                    parent.leftChild  = null;
                } else { //如果该叶节点是父节点的右子节点，将父节点的右子节点置为null
                    parent.rightChild = null;
                }
            }
        } else if (current.rightChild == null) { //2、需要删除的节点有一个子节点，且该子节点为左子节点
            //如果该节点为根节点，将根节点的左子节点变为根节点
            if (current == root) {
                root = current.leftChild;
            } else {
                //如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点
                if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {  //如果该节点是父节点的右子节点，将该节点的左子节点变为父节点的右子节点
                    parent.rightChild = current.leftChild;
                }
            }
        } else if (current.leftChild == null) { //2、需要删除的节点有一个子节点，且该子节点为右子节点
            //如果该节点为根节点，将根节点的右子节点变为根节点
            if (current == root) {
                root = current.rightChild;
            } else {
                //如果该节点是父节点的左子节点，将该节点的右子节点变为父节点的左子节点
                if (isLeftChild) {
                    parent.leftChild = current.rightChild;
                } else {  //如果该节点是父节点的右子节点，将该节点的右子节点变为父节点的右子节点
                    parent.rightChild = current.rightChild;
                }
            }
        } else { //3、需要删除的节点有两个子节点，需要寻找该节点的后续节点替代删除节点
            Node successor = getSuccessor(current);
            //如果该节点为根节点，将后继节点变为根节点，并将根节点的左子节点变为后继节点的左子节点
            if (current == root) {
                root = successor;
            } else {
                //如果该节点是父节点的左子节点，将该节点的后继节点变为父节点的左子节点
                if (isLeftChild) {
                    parent.leftChild = successor;
                } else {  //如果该节点是父节点的右子节点，将该节点的后继节点变为父节点的右子节点
                    parent.rightChild = successor;
                }
            }
        }
        current = null;
        return true;
    }
    /**
     *
     * 得到后继节点，即删除节点的左后代
     */
    private Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = null;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        //如果后继节点不是删除节点的右子节点时，
        if (successor != delNode.rightChild) {
            //要将后继节点的右子节点指向后继结点父节点的左子节点，
            successorParent.leftChild = successor.rightChild;
            //并将删除节点的右子节点指向后继结点的右子节点
            successor.rightChild = delNode.rightChild;
        }
        //任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点
        successor.leftChild = delNode.leftChild;

        return successor;
    }
}
