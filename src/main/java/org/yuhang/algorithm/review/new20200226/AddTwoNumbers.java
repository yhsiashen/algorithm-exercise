package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.ListNode;

/**
 * 两数相加
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode dummy = new ListNode(-1);
         ListNode p =dummy;
         int carry = 0;//进位
         while (l1 !=null || l2 !=null){
             int n1 = 0;
             int n2 = 0;
             if(l1!=null) n1 = l1.val;
             if(l2!=null) n2 = l2.val;
             int sum = n1+n2+carry;
             carry = sum / 10;
             sum = sum % 10;
             p.next = new ListNode(sum);
             p = p.next;
             if(l1!=null) l1 = l1.next;
             if(l2!=null) l2 = l2.next;
         }
         if(carry != 0){
             p.next = new ListNode(carry);
         }
         return dummy.next;

    }

}
