package harmo.projects.nonLinearStructures;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private BinaryTreeNode root;

    private static class BinaryTreeNode {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private int data;//can be of any generic type
        public BinaryTreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree();
        System.out.println("Recursive Preorder-->");
        tree.preOrderRecursive(tree.root);
        System.out.println();
        System.out.println("Iterative Preorder-->");
        tree.preOrderIterative(tree.root);
        System.out.println("InOrder Recursive -->");
        tree.inOrderRecursive(tree.root);
        System.out.println();
        System.out.println("InOrder Iterative -->");
        tree.inOrderIterative(tree.root);
        System.out.println();
        System.out.println("PostOrder Recursive -->");
        tree.postOrderRecursive(tree.root);
        System.out.println();
        System.out.println("PostOrder Iterative -->");
        tree.postOrderIterative(tree.root);
        System.out.println();
        System.out.println("Level Order Traversal -->");
        tree.levelOrder(tree.root);
        System.out.println();
        System.out.println("Max: " + tree.findMax());
    }

    private int findMax(){
        return findMax(root);
    }
    private int findMax(BinaryTreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result) result = left;
        if(right > result) result = right;
        return result;
    }

    private void levelOrder(BinaryTreeNode root){
        if(root == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            BinaryTreeNode temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }


    private void postOrderIterative(BinaryTreeNode root){

        BinaryTreeNode current = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while(current != null|| !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                BinaryTreeNode temp = stack.peek().right;
                if(temp == null){
                    do {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    } while (!stack.isEmpty() && temp == stack.peek().right);
                }else{
                    current = temp;
                }
            }
        }
    }
    private void postOrderRecursive(BinaryTreeNode root) {
        if (root == null) return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }
    private void inOrderIterative(BinaryTreeNode root) {
        if (root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode temp = root;
        while(temp != null || !stack.isEmpty()){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    private void inOrderRecursive(BinaryTreeNode root) {
        if (root == null) return;
        inOrderRecursive(root.left);
        System.out.print(root.data + " ");
        inOrderRecursive(root.right);
    }

    private void preOrderIterative(BinaryTreeNode root) {
        if (root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
        System.out.println();
    }


    private void preOrderRecursive(BinaryTreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
    public void createBinaryTree() {
        BinaryTreeNode first = new BinaryTreeNode(9);
        BinaryTreeNode second = new BinaryTreeNode(2);
        BinaryTreeNode third = new BinaryTreeNode(3);
        BinaryTreeNode fourth = new BinaryTreeNode(4);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
    }
}
