class Solution {
    int preindex;
    HashMap<Integer, Integer> hm;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preindex = 0;
        hm = new HashMap();
        
        for(int i=0; i<inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        
        TreeNode root = new TreeNode();
        
        root = recurse(preorder, preindex, inorder.length-1);
        
        return root;
    }
    public TreeNode recurse(int[] arr, int left, int right) {
        
        if(left > right) return null;
        
        TreeNode node = new TreeNode();
        
        node.val = arr[preindex];
        
        preindex++;
        
        node.left = recurse(arr, left, hm.get(node.val)-1);
        node.right = recurse(arr, hm.get(node.val)+1, right);
        return node;
    }
}