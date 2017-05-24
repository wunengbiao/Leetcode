package LinkedList;

/**
 * Created by wunengbiao on 2017/5/17.
 */
public class Test {

    public static void main(String[] args){
        ListNode root=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);

        root.next=node1;
        node1.next=node2;

        ListNode p=root;
        root=root.next;
        System.out.println(p);
    }
}
