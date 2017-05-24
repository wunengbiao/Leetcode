package LinkedList;

/**
 * Created by wunengbiao on 2017/5/17.
 */
public class Reverse_Nodes_in_k_Group_25 {
    /*public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root=new ListNode(-1);
        ListNode p=root;

        ListNode q=head;
        ListNode t=head;

        while(q!=null){

            int count=0;
            while(q!=null && count<k){
                q=q.next;
                count++;
            }
            if(count==k){

                while(count-->0){
                    head=head.next;
                    ListNode after=p.next;
                    p.next=t;
                    t.next=after;
                    t=head;
                }

                while(p.next!=null){
                    p=p.next;
                }
            }else{
                while(t!=null){
                    p.next=t;
                    p=p.next;
                    t=t.next;
                }
            }
        }

        return root.next;
    }*/

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;

        int count=0;
        while(cur!=null && count!=k){
            cur=cur.next;
            count++;
        }

        if(count==k){
            cur=reverseKGroup(cur,k);

            while(count-->0){
                ListNode tmp=head.next;
                head.next=cur;
                cur=head;
                head=tmp;
            }
            head=cur;
        }
        return head;
    }

    public static void main(String[] args){
        Reverse_Nodes_in_k_Group_25 s=new Reverse_Nodes_in_k_Group_25();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        System.out.println(s.reverseKGroup(node1,3));
    }
}
