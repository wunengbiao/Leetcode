package leet;

/**
 * Created by wunengbiao on 2017/7/8.
 */
public class Reorder_List_143 {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        ListNode prev=null,slow=head,fast=head,l1=head;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;

        ListNode l2=reverse(slow);
        head=merge(l1,l2);
    }

    private ListNode reverse(ListNode head){
        ListNode prev=null,curr=head,next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode res=new ListNode(-1);

        ListNode p=res;
        while(l1!=null){
            p.next=l1;
            l1=l1.next;
            p=p.next;
            p.next=l2;
            l2=l2.next;
            p=p.next;
        }
        if(l2!=null) p.next=l2;
        return res.next;
    }

    public static void main(String[] args){
        Reorder_List_143 s=new Reorder_List_143();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        s.reorderList(node1);
        System.out.println(node1);
    }
}
