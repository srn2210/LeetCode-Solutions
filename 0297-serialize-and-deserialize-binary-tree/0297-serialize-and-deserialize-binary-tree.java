/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        StringBuilder ans = new StringBuilder();
        var q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                var t = q.poll();
                if(t == null) {
                    ans.append(",null");
                }
                else {
                    if(!ans.isEmpty())ans.append(",");
                    ans.append(String.valueOf(t.val));
                    q.add(t.left);
                    q.add(t.right);
                }
            }
        }
        //System.out.println(ans.toString());
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        var arr = data.split(",");
        TreeNode ans = new TreeNode(Integer.parseInt(arr[0]));
        var q = new LinkedList<TreeNode>();
        q.add(ans);
        int idx = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                var node = q.poll();
                //if(!arr[idx].equals("null")) {
                    if(idx + 1 < arr.length && !arr[idx+1].equals("null")) {
                        node.left = new TreeNode(Integer.parseInt(arr[idx+1]));
                        q.add(node.left);
                    }
                    if(idx + 2 < arr.length && !arr[idx+2].equals("null")) {
                        node.right = new TreeNode(Integer.parseInt(arr[idx+2]));
                        q.add(node.right);
                    }
                    idx += 2;
                //}
            }
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));