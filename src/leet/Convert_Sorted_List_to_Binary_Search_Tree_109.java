package leet;

/**
 * Created by wunengbiao on 2017/7/5.
 */
public class Convert_Sorted_List_to_Binary_Search_Tree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }

    public TreeNode toBST(ListNode head,ListNode tail){
        if(head==tail) return null;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=tail && fast.next!=tail){
            slow=slow;
            fast=fast.next.next;
        }

        TreeNode root=new TreeNode(slow.val);
        root.left=toBST(head,slow);
        root.right=toBST(slow.next,tail);
        return root;
    }
}
