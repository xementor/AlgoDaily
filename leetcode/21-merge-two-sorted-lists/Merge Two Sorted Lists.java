/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {  
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        
       
        
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
        
      
    }
    
     ListNode another(ListNode list1, ListNode list2){
        ListNode temp = new ListNode();
        if((list1 == null || list1.next == null) || (list2 == null || list2.next == null)){
            temp =  list1.val > list2.val ? list2 : list1;
        }
        
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);  
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
        }
        return temp;
    }
    
    
    ListNode head = new ListNode();
    ListNode headPtr = head;
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2){
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                head.next = new ListNode(list2.val);
                head = head.next;
                list2 = list2.next;
            }else{
                head.next = new ListNode(list1.val);
                head = head.next;
                list1 = list1.next;
            }
        }
        
        while(list1 != null){
            head.next = new ListNode(list1.val);
            head = head.next;
            list1 = list1.next;
        }
        
        while(list2 != null){
            head.next = new ListNode(list2.val);
            head = head.next;
            list2 = list2.next;
        }
        return headPtr.next;
    }
    
}