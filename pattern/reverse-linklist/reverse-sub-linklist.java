class LinkList{
    LinkList next = null;
    int data;
}

class ReverseSubList {
    static LinkList reverse(ListNode head, int p, int q){
        if (p ==  q){
            return head;
        }


        ListNode current = head, previous = null;
        for (int i=0; current != null && i <p-1; ++i){
            previous = current;
            current = current.next;
        }
        
        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSubList = current;
        ListNode next = null;

        for(int i=0; current != null && i < q-p+1; i++){
            next = current.next;
            current.next = previous;
            current.next = previous;
            current = next;
        }

        if (lastNodeOfFirstPart != null)
            lastNodeOfFirstPart.next = previous;
        else
            head = previous;        
            
        lastNodeOfFirstPart.next = current;

        return head;            
    }
}