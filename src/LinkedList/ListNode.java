package LinkedList;

/**
 * Created by wunengbiao on 2016/12/16.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){val=x;}

    @Override
    public String toString() {
        return print(this);
    }

    public String print(ListNode node){
        String res="[";
        while(node!=null){
            res+=node.val;
            if(node.next!=null)
                res+=",";
            node=node.next;
        }
        res+="]";
        return res;
    }
}
