/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;
            Double n = 0.0;
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                sum += node.val;
                n += 1;
            }
            Double avg = sum / n;
            res.add(avg);
        }
        
        return res;
    }
}