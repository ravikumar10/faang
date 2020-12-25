package src.java.problems;

import java.util.ArrayList;
import java.util.List;

public class P23 {
    public static void main(String[] args) {


    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> intermediate = new ArrayList<>();
        pathSumUtil(result,intermediate, root, sum);
        return result;
    }

    public void pathSumUtil(List<List<Integer>> result, List<Integer> intermediate, TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        intermediate.add(root.val);

        if(root.left == null && root.right == null && sum == root.val) {
            result.add(intermediate);
            return ;
        }
        pathSumUtil(result, new ArrayList<>(intermediate), root.left, sum-root.val);
        pathSumUtil(result, new ArrayList<>(intermediate), root.right, sum-root.val);

    }

     class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }

}

/*
https://leetcode.com/problems/path-sum-ii/
 */