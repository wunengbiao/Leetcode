package LinkedList;

/**
 * Created by wunengbiao on 2017/5/17.
 */
public class Remove_Nth_Node_From_End_of_List_19 {
    ListNode res;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        res=head;
        backtrack(head,n,null);
        return res;
    }



    public int backtrack(ListNode root,int n,ListNode pre){
        if(root==null) return 0;
        int count=backtrack(root.next,n,root);

        if(count+1==n){
            if(pre==null){
                res=res.next;
            }else{
                pre.next=root.next;
            }
        }

        return count+1;
    }

    public static void main(String[] args){
        Remove_Nth_Node_From_End_of_List_19 s=new Remove_Nth_Node_From_End_of_List_19();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        System.out.println(s.removeNthFromEnd(node1,2));
    }
}
