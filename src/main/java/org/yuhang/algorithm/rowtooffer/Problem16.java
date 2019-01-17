package org.yuhang.algorithm.rowtooffer;

/**
 * 合并两递增链表
 * Created by chinalife on 2018/5/12.
 */
public class Problem16 {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 ==null && list2 ==null){
            return null;
        }
        if(list1 ==null)
            return list2;
        if(list2 ==null)
            return list1;


        ListNode resultListNode  = null;
        if(list1.val <= list2.val){
            resultListNode = new ListNode(list1.val);
            list1 = list1.next;
        }else{
            resultListNode = new ListNode(list2.val);
            list2 = list2.next;
        }

        while (list2!= null && list1 !=null){
            if(list1.val <= list2.val){
                insertListNode(resultListNode,list1.val);
                list1 = list1.next;
            }else{
                insertListNode(resultListNode,list2.val);
                list2 = list2.next;
            }
        }
        if(list1!=null){
            insertListNode(resultListNode,list1);
        }

        if(list2!=null){
            insertListNode(resultListNode,list2);
        }

        return resultListNode;
    }

    public void insertListNode(ListNode listNode ,int val){
        while (true){
            if(listNode.next!=null){
                listNode = listNode.next;
                continue;
            }
            listNode.next = new ListNode(val);
            break;
        }
    }
    public void insertListNode(ListNode listNode, ListNode node){
        while (true){
            if(listNode.next!= null){
                listNode = listNode.next;
                continue;
            }
            listNode.next = node;
            break;
        }
    }

    public static void main(String[] args) {
        Problem16  p =new Problem16();
        ListNode list1 = new ListNode(1);
        p.insertListNode(list1,3);
        p.insertListNode(list1,5);
        p.insertListNode(list1,7);
        p.insertListNode(list1,9);
        ListNode list2 = new ListNode(2);
        p.insertListNode(list2,4);
        p.insertListNode(list2,6);
        p.insertListNode(list2,8);
        p.insertListNode(list2,10);

        p.Merge(list1,list2);


    }
}
