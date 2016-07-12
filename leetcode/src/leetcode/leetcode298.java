package leetcode;

public class leetcode298 {
	private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return max;
        helper(root, root.val, 0);
        return max;
    }
    
    private void helper(TreeNode root, int target, int cur){
        if(root == null) return;
        if(root.val == target) cur++;
        else cur = 1;
        max = Math.max(cur, max);
        helper(root.left, root.val+1, cur);
        helper(root.right, root.val+1, cur);
    }
}
