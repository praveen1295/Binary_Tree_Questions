import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class pre_order_traversal {

    // Recursive function to perform preorder traversal on the tree
    public static void preorder_recursive(Node root) {
        // return if the current node is empty
        if (root == null) {
            return;
        }

        // Display the data part of the root (or current node)
        System.out.print(root.data + " ");

        // Traverse the left subtree
        preorder_recursive(root.left);

        // Traverse the right subtree
        preorder_recursive(root.right);
    }

    static void preorder_iterative(Node root) {

        if (root == null)
            return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.empty()) {
            Node curr = st.pop();
            System.out.print(curr.data + " ");

            if (curr.right != null) {
                st.push(curr.right);
            }

            if (curr.left != null) {
                st.push(curr.left);
            }
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("Recursive Approach :");
        preorder_recursive(root);
        System.out.println();
        System.out.println("Iterative Approach :");
        preorder_iterative(root);
    }
}
