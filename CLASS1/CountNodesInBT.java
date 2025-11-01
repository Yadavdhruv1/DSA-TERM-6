package CLASS1;

/*
------------------------------------------------------------
🧠 Topic: Count the Number of Nodes in a Binary Tree
------------------------------------------------------------

📘 Concept:
The number of nodes in a binary tree = 
   (number of nodes in left subtree)
 + (number of nodes in right subtree)
 + 1 (for the root node itself)

So, we can recursively count all nodes in the tree.

------------------------------------------------------------
🔧 Approach:
1️⃣ If the tree is empty (root == null), return 0.  
2️⃣ Otherwise, return:
      countNodes(root.left) + countNodes(root.right) + 1

------------------------------------------------------------
📊 Example:

            1
          /   \
         2     3
        / \   / \
       4  5  6  7

Expected Output: 7 nodes

------------------------------------------------------------
🧩 Dry Run:

→ Start from root (1)
   → countNodes(1)
      = 1 + countNodes(2) + countNodes(3)

→ countNodes(2)
   = 1 + countNodes(4) + countNodes(5)
   = 1 + 1 + 1 = 3

→ countNodes(3)
   = 1 + countNodes(6) + countNodes(7)
   = 1 + 1 + 1 = 3

→ Total = 1 + 3 + 3 = 7 ✅

------------------------------------------------------------
*/

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class CountNodesInBT {

    // Function to count total nodes in the binary tree
    static int countNodes(TreeNode root) {

        // Base Case: If tree is empty
        if (root == null)
            return 0;

        // Recursive Case: Count left + right + current node
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int totalNodes = countNodes(root);

        System.out.println("✅ Total number of nodes in the binary tree: " + totalNodes);
    }
}

