/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> path1;
    List<TreeNode> path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        Backtrack(root, p, path1);
        Backtrack(root, q, path2);
        for(int i = 0; i < path1.size(); i++){
            if(path1.get(i) != path2.get(i)){
                return path1.get(i - 1);
            }
        }
        return null;
    }
    
    private void Backtrack(TreeNode root, TreeNode p, List<TreeNode> path){
        if(root == null) return;
        if(root == p) {
            path.add(root);
            path.add(root);
            return;
        }
        
        path.add(root);
        Backtrack(root.left, p, path);
        Backtrack(root.right, p, path);
        if(path.get(path.size() - 1) == p){
            return;
        }
        path.remove(path.size() - 1);
    }
}