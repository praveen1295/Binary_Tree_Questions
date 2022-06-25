public class heightOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node root = new Node(nodes[idx]);
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }

    static int height_of_tree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height_of_tree(root.left);
        int rightHeight = height_of_tree(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1 };
        heightOfTree tree = new heightOfTree();
        Node root = tree.buildTree(nodes);
        System.out.println(tree.height_of_tree(root));
    }
}
