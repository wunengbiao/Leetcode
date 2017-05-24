package LinkedList;

import java.util.List;

/**
 * Created by wunengbiao on 2017/5/17.
 */
public class Add_Two_Numbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(-1);
        ListNode p=res;
        int carry=0;

        while(l1!=null || l2!=null){
            int v1=l1==null?0:l1.val;
            int v2=l2==null?0:l2.val;

            int value=v1+v2+carry;
            if(value>=10){
                carry=1;
                p.next=new ListNode(value-10);
            }else{
                carry=0;
                p.next=new ListNode(value);
            }

            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            p=p.next;
        }

        if(carry==1){
            p.next=new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args){
        Add_Two_Numbers_2 s=new Add_Two_Numbers_2();
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1=new ListNode(2);
        ListNode node1=new ListNode(4);
        ListNode node2=new ListNode(3);
        l1.next=node1;node1.next=node2;

        ListNode l2=new ListNode(5);
        ListNode node3=new ListNode(6);
        ListNode node4=new ListNode(4);
        l2.next=node3;
        node3.next=node4;

        System.out.println(s.addTwoNumbers(l1,l2));
    }
}
