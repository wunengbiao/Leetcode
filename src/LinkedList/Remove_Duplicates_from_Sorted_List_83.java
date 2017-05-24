package LinkedList;

/**
 * Created by wunengbiao on 2017/5/17.
 */
public class Remove_Duplicates_from_Sorted_List_83 {
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null) return head;
        ListNode res=head;
        ListNode p=res;

        head=head.next;
        while(head!=null){
            if(head.val==p.val){
                head=head.next;
            }else{
                p.next=head;
                head=head.next;
                p=p.next;
            }
        }
        p.next=null;

        return res;
    }

    public static void main(String[] args){
        Remove_Duplicates_from_Sorted_List_83 s=new Remove_Duplicates_from_Sorted_List_83();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
//        ListNode node3=new ListNode(3);
//        ListNode node4=new ListNode(3);
//        ListNode node5=new ListNode(4);
//        ListNode node6=new ListNode(5);
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
//        node5.next=node6;

        System.out.println(s.deleteDuplicates(node1));

    }
}
