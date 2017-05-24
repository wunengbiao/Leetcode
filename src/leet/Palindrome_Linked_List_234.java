package leet;

/**
 * Created by wunengbiao on 2017/4/6.
 */
public class Palindrome_Linked_List_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode root=new ListNode(Integer.MIN_VALUE);
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        if(fast!=null){
            slow=slow.next;
        }
        slow=reverse(slow);

        while(slow!=null){
            if(slow.val!=head.val) return false;
            slow=slow.next;
            head=head.next;
        }
        return true;


    }

    public ListNode reverse(ListNode root){
        ListNode res=new ListNode(Integer.MIN_VALUE);
        while(root!=null){
            ListNode p=root.next;
            ListNode temp=res.next;
            res.next=root;
            root.next=temp;
            root=p;
        }
        return res.next;
    }

    public static void main(String[] args){
        Palindrome_Linked_List_234 s=new Palindrome_Linked_List_234();
        ListNode node1=new ListNode(1);
//        ListNode node2=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(1);

        node1.next=node2;
        node2.next=node3;
//        node3.next=node4;
        System.out.println(s.isPalindrome(node1));
//        System.out.println(s.reverse(node1));
    }
}
