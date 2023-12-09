package LinearDataStructure;

import java.util.*;

public class Test {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String token[] = input.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(token[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 1;
        while (q.size() > 0 && idx < token.length) {

            int size = q.size();
            while (size-- > 0) {
                TreeNode rv = q.remove();
                if (token[idx].equals("null")) {
                    rv.left = null;
                } else {
                    rv.left = new TreeNode(Integer.parseInt(token[idx]));
                    q.add(rv.left);
                }
                idx++;
                if (token[idx].equals("null")) {
                    rv.right = null;
                } else {
                    rv.right = new TreeNode(Integer.parseInt(token[idx]));
                    q.add(rv.right);
                }
                idx++;
            }

        }



    }

    public static int rec(TreeNode root){
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return root.val;
        int left=rec(root.left);
        int right=rec(root.right);
        return Math.max(left,right)+root.val;
    }
}
// 9:00,9:40
// 9:10,12:10
