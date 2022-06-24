class binaryTree {
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

    static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countNode(root.left);
        int rightNodes = countNode(root.right);

        return leftNodes + rightNodes + 1;
    }
}

public class count_of_nodes {
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1 };
        binaryTree tree = new binaryTree();
        binaryTree.Node root = tree.buildTree(nodes);
        System.out.println(tree.countNode(root));
    }
}
