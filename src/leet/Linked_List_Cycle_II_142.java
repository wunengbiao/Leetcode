package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2017/7/4.
 */
public class Linked_List_Cycle_II_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                while(head!=slow){
                    head=head.next;
                    slow=slow.next;
                }
                    return slow;
                }
            }
        return null;
    }
}
