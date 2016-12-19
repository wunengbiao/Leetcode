package leet;

/**
 * Created by wunengbiao on 2016/12/16.
 */
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {

        if(head==null) return null;
        return toBST(head,null);

    }

    public TreeNode toBST(ListNode head,ListNode tail){
        ListNode slow=head;
        ListNode fast=head;
        if(head==tail) return null;

        while(fast!=tail && fast.next!=tail){
            slow=slow.next;
            fast=fast.next.next;
        }

        TreeNode root=new TreeNode(slow.val);
        root.left=toBST(head,slow);
        root.right=toBST(slow.next,tail);
        return root;
    }
}
