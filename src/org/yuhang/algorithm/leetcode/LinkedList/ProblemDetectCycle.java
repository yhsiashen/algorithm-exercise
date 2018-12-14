package org.yuhang.algorithm.leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 返回链表开始入环的那个节点，若没有环，则返回null  142
 * Created by chinalife on 2018/10/24.
 */
public class ProblemDetectCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        //判断是否有环
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                flag = true;
                break;
            }
        }
        //找出环的入口节点,从头节点开始遍历，将所有节点放到hashSet中，若有重复，则此节点为入口节点
        Set<ListNode> listNodeSet = new HashSet<ListNode>();
        if(flag){
          while (true){
              if(!listNodeSet.add(head)){
                  return head;
              }
              head = head.next;
          }
        }else {
          return null;
        }

    }

}
