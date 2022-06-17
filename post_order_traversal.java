import java.util.Stack;

import javax.sound.midi.Track;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class post_order_traversal {

     // Recursive function to perform postorder traversal on the tree
     public static void postorder_recursive(Node root)
     {
         // return if the current node is empty
         if (root == null) {
             return;
         }
     
         // Traverse the left subtree
         postorder_recursive(root.left);
     
         // Traverse the right subtree
         postorder_recursive(root.right);
     
         // Display the data part of the root (or current node)
         System.out.print(root.data + " ");
     }


    static void post_order_iterative(Node root) {

        if (root == null)
            return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        Stack<Integer> out = new Stack<>();

        while (!st.empty()) {
            Node curr = st.pop();
            out.push(curr.data);
            if (curr.left != null) {
                st.push(curr.left);
            }
            if (curr.right != null) {
                st.push(curr.right);
            }
        }

        while (!out.empty()) {
            System.out.print(out.pop() + " ");
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
        postorder_recursive(root);
        System.out.println();
        System.out.println("Iterative Approach :");
        post_order_iterative(root);
    }
}
