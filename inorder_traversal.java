import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class inorder_traversal {

     // Recursive function to perform inorder traversal on the tree
     public static void inorder_recursive(Node root)
     {
         // return if the current node is empty
         if (root == null) {
             return;
         }
     
         // Traverse the left subtree
         inorder_recursive(root.left);
     
         // Display the data part of the root (or current node)
         System.out.print(root.data + " ");
     
         // Traverse the right subtree
         inorder_recursive(root.right);
     }


    static void inorderIterative(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (!st.empty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
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
        inorder_recursive(root);
        System.out.println();
        System.out.println("Iterative Approach :");
        inorderIterative(root);
    }
}