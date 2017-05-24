package LinkedList;

import java.util.List;

/**
 * Created by wunengbiao on 2017/5/17.
 */
public class Remove_Duplicates_from_Sorted_List_II_82 {
    public ListNode deleteDuplicates(ListNode head) {
       if(head==null) return null;
       if(head.next!=null && head.val==head.next.val){
           while(head.next!=null && head.val==head.next.val){
               head=head.next;
           }

           return deleteDuplicates(head.next);
       }else{
           head.next=deleteDuplicates(head.next);
       }
       return head;
    }

    public static void main(String[] args){
        Remove_Duplicates_from_Sorted_List_II_82 s=new Remove_Duplicates_from_Sorted_List_II_82();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(4);
        ListNode node6=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        System.out.println(s.deleteDuplicates(node1));
    }

}
