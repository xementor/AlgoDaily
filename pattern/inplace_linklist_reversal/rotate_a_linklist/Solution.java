package pattern.inplace_linklist_reversal.rotate_a_linklist;

import pattern.ListNode;

public class Solution {
  public static ListNode rotate(ListNode head, int rotations) {
    if (head == null || head == null) return head;
    ListNode lastNode = head;
    int listLength = 1;

    while (lastNode.next != null) {
      lastNode = lastNode.next;
      listLength ++;
    }

    lastNode.next = head;
    rotations %= listLength;

    int skipLenght = listLength - rotations;
    ListNode lastNodeofRotationList = head;

    for (int i=0; i<skipLenght; i++) lastNodeofRotationList = lastNodeofRotationList.next;

    head = lastNodeofRotationList.next;
    lastNodeofRotationList.next = null;
    return head;
  }
}
