public class 两数相加 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res=new ListNode();
        ListNode cur=res;
        int carry=0;
        while(l1!=null||l2!=null){

            int value1=l1==null?0:l1.val;
            int value2=l2==null?0:l2.val;
            int sum=(value1+value2+carry)%10;
            carry=(value1+value2+carry)/10;
            cur.next=new ListNode(sum);
            cur=cur.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }

        if(carry==1)
            cur.next=new ListNode(1);


        return res.next;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1,l2);


    }
}
