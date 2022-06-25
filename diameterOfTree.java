public class diameterOfTree {
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

    static int diameter_of_tree(Node root) {  // Diameter of tree is Number of nodes in the  
                                              //longest path between any two nodes;
        if (root == null) {
            return 0;
        }
        int diam1 = diameter_of_tree(root.left);
        int diam2 = diameter_of_tree(root.right);
        int diam3 = height_of_tree(root.left) + height_of_tree(root.right) + 1;

        int myDiam = Math.max(Math.max(diam1, diam2), diam3);
        return myDiam;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1 };
        diameterOfTree tree = new diameterOfTree();
        Node root = tree.buildTree(nodes);
        System.out.println(tree.diameter_of_tree(root));
    }
}
