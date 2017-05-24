package LinkedList;

/**
 * Created by wunengbiao on 2017/5/17.
 */
public class Swap_Nodes_in_Pairs_24 {
    public ListNode swapPairs(ListNode head) {
        helper(head,0,null);
        return result.next;
    }

    ListNode result=new ListNode(-1);
    ListNode res=result;
    public void helper(ListNode head,int n,ListNode pre){
        if(head==null){
            res.next=pre;
            return;
        }
        if((n&1)==0){
            ListNode nextNode=head.next;
            head.next=null;
            helper(nextNode,n+1,head);

        }
        else{
            ListNode nextNode=head.next;
            head.next=null;
            res.next=head;
            res=res.next;
            res.next=pre;
            res=res.next;


            helper(nextNode,n+1,null);
        }
    }

    public static void main(String[] args){
        Swap_Nodes_in_Pairs_24 s=new Swap_Nodes_in_Pairs_24();

        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println(node1);
        System.out.println(s.swapPairs(node1));
    }
}
