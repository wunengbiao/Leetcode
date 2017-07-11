package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2017/7/9.
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II {

//    Map<Integer,TreeLinkNode> prev=new HashMap<>();
//    public void connect(TreeLinkNode root) {
//        helper(root,0);
//    }
//
//    public void helper(TreeLinkNode root,int level){
//        if(root==null) return;
//        if(!prev.containsKey(level)){
//            root.next=null;
//            prev.put(level,root);
//        }else{
//            TreeLinkNode pre=prev.get(level);
//            pre.next=root;
//            root.next=null;
//            prev.put(level,root);
//        }
//
//        helper(root.left,level+1);
//        helper(root.right,level+1);
//    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }

    public static void main(String[] args){
        Populating_Next_Right_Pointers_in_Each_Node_II s=new Populating_Next_Right_Pointers_in_Each_Node_II();

        TreeLinkNode root=new TreeLinkNode(1);
        TreeLinkNode node1=new TreeLinkNode(3);
        TreeLinkNode node2=new TreeLinkNode(4);
        TreeLinkNode node3=new TreeLinkNode(5);
        TreeLinkNode node4=new TreeLinkNode(6);
        TreeLinkNode node5=new TreeLinkNode(7);

        root.left=node1;
        root.right=node4;
        node4.right=node5;
        node1.left=node2;
        node1.right=node3;

        root.left=node1;
        root.right=node2;

        s.connect(root);
    }
}
