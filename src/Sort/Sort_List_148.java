package Sort;

/**
 * Created by wunengbiao on 2017/3/25.
 *
 * 归并排序 递归算法
 */
public class Sort_List_148 {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }

        ListNode p1=head;
        ListNode p2=head;
        ListNode pre=head;

        while(p2!=null && p2.next!=null){
            pre=p1;
            p1=p1.next;
            p2=p2.next.next;
        }

        pre.next=null;

        ListNode h1=sortList(head);
        ListNode h2=sortList(p1);

        return merge(h1,h2);

    }

    public ListNode merge(ListNode h1,ListNode h2){
        if(h1==null)
            return h2;
        if(h2==null)
            return h1;

        if(h1.val<h2.val){
            h1.next=merge(h1.next,h2);
            return h1;
        }else{
            h2.next=merge(h1,h2.next);
            return h2;
        }
    }

    public static void main(String[] args){

        Sort_List_148 solution=new Sort_List_148();

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
