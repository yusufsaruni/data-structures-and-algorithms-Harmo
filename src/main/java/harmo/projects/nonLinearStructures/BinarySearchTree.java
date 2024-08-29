package harmo.projects.nonLinearStructures;

public class BinarySearchTree {

    private BinaryTreeNode root;

    private static class BinaryTreeNode {
        private int data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        public BinaryTreeNode(int data) {
            this.data = data; // can be any generic type.
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.inOrder();
        if(tree.isValid(tree.root, Integer.MIN_VALUE,Integer.MAX_VALUE)) {
            System.out.println("Tree is valid");
        }else{
            System.out.println("Tree is not valid");
        }


        if(tree.search(10) != null){
            System.out.println("Key found: "+tree.search(10).data);
        }else{
            System.out.println("Key not found");
        }
        if(tree.search(1) != null){
            System.out.println("Key found: "+tree.search(1).data);
        }else{
            System.out.println("Key not found");
        }
    }
    private boolean isValid(BinaryTreeNode root, long min, long max) {
        if(root == null){
            return true;
        }

        if(root.data <= min || root.data >= max){
            return false;
        }
        //The maximum is the set to the root's data since all the other nodes
        // should have a value that is less than the nodes data.
        boolean left = isValid(root.left,min, root.data);
        if(left){
            //Minimum is set to the root data since all the nodes should
            //be greater than the root's data.
            return isValid(root.right,root.data,max);
        }
        return false;
    }

    private BinaryTreeNode search(int key) {
        return search(root, key);
    }
    private BinaryTreeNode search(BinaryTreeNode root, int key) {
        if(root == null || root.data == key) return root;// base case.
        if(key < root.data) return search(root.left, key);
        else return search(root.right, key);
    }

    private void inOrder(){
        inOrder(root);
    }
    private void inOrder(BinaryTreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private void insert(int data) {
        root = insert(root, data);
    }
    private BinaryTreeNode insert(BinaryTreeNode root, int data) {
        if (root == null) {//base case.
            root = new BinaryTreeNode(data);
            return root;
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        }else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
