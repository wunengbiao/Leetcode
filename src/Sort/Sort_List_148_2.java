package Sort;

/**
 * Created by wunengbiao on 2017/3/25.
 */
public class Sort_List_148_2 {

    public ListNode sortList(ListNode head){
        if(head==null) return head;
        if(head.next==null) return head;

        ListNode slow=head;
        ListNode fast=head;

        ListNode pre=null;
        while(fast!=null && fast.next!=null){
            pre=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        pre.next=null;

        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);

        return merge(l1,l2);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode head=new ListNode(0);
        ListNode p=head;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                p=p.next;
                l1=l1.next;
            }else{
                p.next=l2;
                p=p.next;
                l2=l2.next;
            }
        }
        if(l1!=null) p.next=l1;
        if(l2!=null) p.next=l2;

        return head.next;
    }

    public static void main(String[] args){
        Sort_List_148_2 solution=new Sort_List_148_2();
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(6);
        ListNode node6=new ListNode(5);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        System.out.println(solution.sortList(node1));

    }
}
