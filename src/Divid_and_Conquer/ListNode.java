package Divid_and_Conquer;

public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    @Override
    public String toString() {
        return print(this);
    }

    public String print(ListNode head){
            String res="[";
            while(head!=null){
                res+=head.val;
                if(head.next!=null){
                    res+=',';
                }
                head=head.next;
            }
            res+=']';
            return res;
        }


}