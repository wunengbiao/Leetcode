package Sort;

/**
 * Created by wunengbiao on 2017/3/24.
 */
public class Insertion_Sort_List_147 {
    public ListNode insertionSortList(ListNode head) {
        System.out.println(head);

        ListNode root=new ListNode(Integer.MIN_VALUE);

        ListNode p=head;
        while(p!=null){

            ListNode q=root;
            while(q.next!=null && q.next.val<=p.val)
                q=q.next;

            ListNode tmp=p;
            p=p.next;

            ListNode tmp2=q.next;
            q.next=tmp;
            tmp.next=tmp2;
        }
        return root.next;

    }

    public static void main(String[] args){
        Insertion_Sort_List_147 solution=new Insertion_Sort_List_147();
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(3);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode res=solution.insertionSortList(node1);
        System.out.println(res);

    }
}
