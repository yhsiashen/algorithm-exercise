package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 单链表增删,反转,获得中间节点等操作
 */
public class SinglyList {

    private Node head;

    /**
     * 节点定义
     */
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    /**
     * 构造器
     * @param val
     */
    public SinglyList(int val){
        this.head = new Node(val);
    }

    /**
     * 插入一个节点
     */
    public void insert(int val){
        Node headNode = head;
        while (headNode.next!=null){
            headNode = headNode.next;
        }
        headNode.next = new Node(val);
    }

    /**
     * 删除一个指定节点
     */
    public boolean deleteNode(int val){
        Node headNode = head;
        //若要删除的是头结点，则直接删除
        if(headNode.data == val){
            head = head.next;
            headNode.next=null;//help gc
            return true;
        }
        //若要删除的是中间节点
        while (headNode.next!=null){
            int curVal = headNode.next.data;
            if(curVal==val){
                headNode.next = headNode.next.next;
                headNode.next.next=null; //help gc
                return true;
            }
            headNode = headNode.next;
        }
        return false;
    }

    /**
     * 单链表反转
     * @param list
     */
    public Node reserveList(Node list){
        if(list == null)
             return null;
        Node currentList = list;
        Node preList = null;
        Node result = null;
        while (currentList !=null){
           Node nextList = currentList.next;
           if(nextList==null)
               result = currentList;
           // 将目前节点的下个节点指向preList节点
           currentList.next = preList;
           preList = currentList;
           currentList = nextList;
        }
        return result;
    }


    /**
     * 求链表的中间节点
     * @param list
     * @return
     */
    public Node getMidNode(Node list){
        if(list == null)
            return null;
        Node fast = list;
        Node slow = list;
        while (slow!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==null)
                break;
        }
        return slow;
    }

    public static void main(String[] args) {
        SinglyList singlyList = new SinglyList(3);
        singlyList.insert(4);
        singlyList.insert(5);
        singlyList.insert(1);

        singlyList.deleteNode(3);

    }
}
