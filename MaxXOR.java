public class MaxXOR {
    static class TreeNode {
        TreeNode zero;
        TreeNode one;
    }

    // Insert a number into the trie
    public static void insert(TreeNode root, int n) {
        TreeNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (bit == 0) {
                if (curr.zero == null) {
                    curr.zero = new TreeNode();
                }
                curr = curr.zero;
            } else {
                if (curr.one == null) {
                    curr.one = new TreeNode();
                }
                curr = curr.one;
            }
        }
    }

    // Find maximum XOR for a given number using the trie
    public static int FindXORmax(TreeNode root, int n) {
        TreeNode curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (bit == 0) {
                if (curr.one != null) {
                    ans |= (1 << i);
                    curr = curr.one;
                } else {
                    curr = curr.zero;
                }
            } else {
                if (curr.zero != null) {
                    ans |= (1 << i);
                    curr = curr.zero;
                } else {
                    curr = curr.one;
                }
            }
        }
        return ans;
    }

    // Main function to compute max XOR among all pairs
    public static int max_Xor(int[] arr, int n) {
        TreeNode root = new TreeNode();
        int ans = 0;

        // Insert all numbers into the trie
        for (int i = 0; i < n; i++) {
            insert(root, arr[i]);
        }

        // For each number, find the best XOR match
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, FindXORmax(root, arr[i]));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 8, 4};
        int n = arr.length;
        System.out.println("Maximum XOR is: " + max_Xor(arr, n)); // Expected: 15
    }
}