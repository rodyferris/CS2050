/* Rhodes Ferris
   Program 8
   Binary Search Tree Class
 */
public class BST {
    private BSTNode root;

    public BSTNode getRoot(){
        return this.root;
    }

    public BST() {
        this.root = null;
    }

    public void insert(String x) {
        x = x.toLowerCase().replaceAll("[^a-z]", "");
        if (x.isEmpty()) {
            return;
        }
        this.root = recursiveInsert(this.root, x);
    }

    private BSTNode recursiveInsert(BSTNode root, String x) {
        if (root == null) {
            root = new BSTNode(x);
            return root;
        }

        if (x.compareTo(root.word) < 0) {
            root.left = recursiveInsert(root.left, x);
        } else if (x.compareTo(root.word) > 0) {
            root.right = recursiveInsert(root.right, x);
        }

        return root;
    }
    public int countNodes(BSTNode x) {
        if (x == null) {
            return 0;
        }
        return 1 + countNodes(x.left) + countNodes(x.right);
    }

    public int height(BSTNode x) {
        if (x == null) {
            return 0;
        }
        int leftHeight = height(x.left);
        int rightHeight = height(x.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int maxNodes(int h) {
        return (int) Math.pow(2, h) - 1;
    }
}
