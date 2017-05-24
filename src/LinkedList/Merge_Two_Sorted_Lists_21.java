package LinkedList;

/**
 * Created by wunengbiao on 2017/5/17.
 */
public class Merge_Two_Sorted_Lists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root=new ListNode(-1);
        ListNode p=root;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                p.next=new ListNode(l1.val);
                l1=l1.next;
            }else{
                p.next=new ListNode(l2.val);
                l2=l2.next;
            }

            p=p.next;
        }

        if(l1!=null) p.next=l1;
        if(l2!=null) p.next=l2;

        return root.next;
    }
    public static void main(String[] args){
        Merge_Two_Sorted_Lists_21 s=new Merge_Two_Sorted_Lists_21();
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(1);

        System.out.println(s.mergeTwoLists(l1,l2));
    }
}
