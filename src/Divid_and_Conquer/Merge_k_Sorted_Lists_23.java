package Divid_and_Conquer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wunengbiao on 2017/3/27.
 */
public class Merge_k_Sorted_Lists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 || lists==null) return null;

        PriorityQueue<ListNode> heap=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val) return -1;
                if(o1.val>o2.val) return 1;
                else return 0;
            }
        });

        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;

        for(ListNode node:lists){
            if(node!=null)
                heap.add(node);
        }

        while(!heap.isEmpty()){
            tail.next=heap.poll();
            tail=tail.next;

            if(tail.next!=null)
                heap.add(tail.next);
        }

        return dummy.next;

    }
}
