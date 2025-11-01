package CLASS1;

/*
---------------------------------------------
🧠 CONCEPT: Balanced Binary Tree
---------------------------------------------

A Binary Tree is called **balanced** if, for every node in the tree:
➡️ The height difference between the left and right subtrees is **at most 1**.

That means:
|height(left) - height(right)| ≤ 1 for all nodes

---------------------------------------------
📘 EXAMPLE:
---------------------------------------------

Balanced Tree ✅
        1
       / \
      2   3
     / \
    4   5
   /
  6

Unbalanced Tree ❌
        1
       /
      2
     /
    3
   /
  4

---------------------------------------------
🧩 APPROACH (Efficient Recursive Method):
---------------------------------------------

1️⃣ If the tree is empty → it's balanced.

2️⃣ Recursively find:
   - Height of left subtree
   - Height of right subtree

3️⃣ If at any node, the absolute difference > 1 → not balanced.

4️⃣ To avoid repeated height calculations (which cause O(N²) complexity),
    we calculate height **while checking balance**.

    ⚙️ So, we use a helper function that:
        - Returns the height of the subtree if it's balanced
        - Returns -1 immediately if it's unbalanced

    This makes the time complexity → O(N)

---------------------------------------------
🕹️ DRY RUN EXAMPLE:
---------------------------------------------

Tree:
        1
       / \
      2   3
     /
    4

Step 1: Start from root (1)
→ Check left subtree (2)
    → Check (4): left & right null → height = 1
    → height(2) = 1 + max(1, 0) = 2
→ Check right subtree (3): height = 1
→ |2 - 1| = 1 → balanced ✅
Return true ✅

---------------------------------------------
*/

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BalancedBinaryTree {

    // Function to check if the tree is balanced
    public static boolean isBalanced(TreeNode root) {
        // If height function returns -1 → unbalanced
        return checkHeight(root) != -1;
    }

    // Helper function to check height and balance
    private static int checkHeight(TreeNode node) {
        // Base case: empty tree has height 0
        if (node == null)
            return 0;

        // Recursively get heights of left and right subtrees
        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);

        // If either subtree is unbalanced → propagate -1
        if (leftHeight == -1 || rightHeight == -1)
            return -1;

        // If current node is unbalanced → return -1
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        // Else return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Create tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5); // Makes tree unbalanced

        System.out.println("Is the binary tree balanced? " + isBalanced(root));
    }
}
