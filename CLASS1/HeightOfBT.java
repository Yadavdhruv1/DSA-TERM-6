package CLASS1;

/*
------------------------------------------------------------
🧠 Topic: Find the Height of a Binary Tree
------------------------------------------------------------

📘 Concept:
The *height* (or *depth*) of a binary tree is:
➡️ The number of nodes on the longest path from the root to any leaf node.

For example:
- Height of an empty tree = 0
- Height of a single node tree = 1

------------------------------------------------------------
🔧 Approach (Recursive):
1️⃣ If the tree is empty → return 0  
2️⃣ Otherwise:
       height = 1 + max(height of left subtree, height of right subtree)

------------------------------------------------------------
📊 Example:

            1
          /   \
         2     3
        / \   / 
       4  5  6  

📈 Longest path = 1 → 2 → 4  
So, Height = 3

------------------------------------------------------------
🧩 Dry Run:

→ height(1)
     = 1 + max(height(2), height(3))

→ height(2)
     = 1 + max(height(4), height(5))
     = 1 + max(1, 1)
     = 2

→ height(3)
     = 1 + max(height(6), height(null))
     = 1 + max(1, 0)
     = 2

→ height(1)
     = 1 + max(2, 2)
     = 3 ✅

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

public class HeightOfBT {

    // Function to find the height of a binary tree
    static int findHeight(TreeNode root) {

        // Base Case: empty tree has height 0
        if (root == null)
            return 0;

        // Recursive calls for left and right subtree
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // Height = 1 (for current node) + max(left, right)
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Construct binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int height = findHeight(root);

        System.out.println("✅ Height of the binary tree: " + height);
    }
}

