package leetcode;
import java.util.*;

public class leetcode173 {
	List<Integer> list = new LinkedList<Integer>();
    Iterator<Integer> pos;
    public void BSTIterator(TreeNode root) {
        helper(root);
        pos = list.iterator();
    }
    
    private void helper(TreeNode root){
        if(root == null) return;
        else{
            helper(root.left);
            list.add(root.val);
            helper(root.right);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return pos.hasNext();
    }
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }
}
