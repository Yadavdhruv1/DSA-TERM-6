package CLASS1;
/*
------------------------------------------------------------
🧠 Topic: Check if Two Binary Trees are Mirror Images of Each Other
------------------------------------------------------------

📘 Concept:
Two binary trees are said to be *mirror images* of each other if:
  1. Their root nodes have the same value.
  2. The left subtree of one tree is the mirror of the right subtree of the other tree.
  3. The right subtree of one tree is the mirror of the left subtree of the other tree.

📊 Example:

Tree 1:              Tree 2:
     1                     1
   /   \                 /   \
  2     3               3     2
 / \   / \             / \   / \
4  5  6  7           7  6  5  4

✅ Both trees are mirror images.

------------------------------------------------------------
🔧 Approach:
1️⃣ If both trees are empty → return true.
2️⃣ If one is empty and the other isn’t → return false.
3️⃣ Check if root values are same.
4️⃣ Recursively check:
      - left subtree of Tree1 with right subtree of Tree2
      - right subtree of Tree1 with left subtree of Tree2
5️⃣ Return true only if both recursive checks return true.

------------------------------------------------------------
🧩 Dry Run Example:
Let’s compare the above trees (Tree1 & Tree2):

Step 1: Compare root1 = 1, root2 = 1 → Equal ✅  
Step 2: Check mirror(2, 3)
         - 2 == 3 ❌ → false (but we’ll go deeper recursively)
Step 3: Compare left of 2 (4) with right of 3 (7) → 4 == 7 ❌  
        Compare right of 2 (5) with left of 3 (6) → 5 == 6 ❌
→ These subtrees are not mirrors.

However, for the correct mirror pairs (Tree1.left vs Tree2.right):
→ (2, 2) → Equal ✅
→ (4, 4), (5, 5) → Equal ✅
→ (3, 3) → Equal ✅
→ (6, 6), (7, 7) → Equal ✅
→ Hence both trees are mirrors. ✅

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

public class MirrorBinaryTree {

    // Function to check if two trees are mirrors
    static boolean isMirror(TreeNode root1, TreeNode root2) {

        // If both trees are empty → mirrors
        if (root1 == null && root2 == null)
            return true;

        // If one is empty and the other is not → not mirrors
        if (root1 == null || root2 == null)
            return false;

        // Check current node values
        if (root1.data != root2.data)
            return false;

        // Check mirror property for subtrees
        boolean leftMirror = isMirror(root1.left, root2.right);
        boolean rightMirror = isMirror(root1.right, root2.left);

        // Return true if both sides are mirrors
        return leftMirror && rightMirror;
    }

    public static void main(String[] args) {
        // Construct Tree 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        // Construct Tree 2 (mirror of Tree 1)
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(7);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(4);

        if (isMirror(root1, root2))
            System.out.println("✅ Both trees are mirror images of each other!");
        else
            System.out.println("❌ Trees are not mirror images.");
    }
}
