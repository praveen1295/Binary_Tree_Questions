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

    static Node root = null;
    static int idx = -1;

    Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    int SumOfNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = SumOfNode(root.left);
        int rightNodes = SumOfNode(root.right);

        return leftNodes + rightNodes + root.data;
    }
}

public class sum_of_nodes {
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binaryTree tree = new binaryTree();
        binaryTree.Node root = tree.buildTree(nodes);
        System.out.println(tree.SumOfNode(root));
    }
}
