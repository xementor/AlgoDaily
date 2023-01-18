/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1,n2) -> n1.val - n2.val);

        for(ListNode root: lists){
            if (root != null)
                minHeap.add(root);
        }

        ListNode resultHead = null, resultTail = null;

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();

            if (resultHead == null){
                resultHead = resultTail = node;
            } else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }

            if(node.next != null)
                minHeap.add(node.next);
        }

        return resultHead;
        
   }
}
// @lc code=end

