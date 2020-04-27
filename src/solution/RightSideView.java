package solution;

import defined.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class RightSideView {
    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     */
    List<Integer> rightSide=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root){
        dfs(root,0);
        return rightSide;
    }

    public void dfs(TreeNode node, int depth){
        if(node==null){
            return;
        }
        if(depth==rightSide.size()){
            rightSide.add(node.val);
        }
        depth++;
        dfs(node.right,depth);
        dfs(node.left,depth);
    }

}
