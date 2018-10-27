package org.yuhang.algorithm.jiketime;

/**
 * Created by chinalife on 2018/10/8.
 */
public class SinglyLinkedList {
    /**
     * 1）单链表的插入、删除、查找操作；
     * 2）链表中存储的是int类型的数据；
     * <p>
     * Author：Zheng
     */
    private Node head = null;

    //单链表反转
    private static Node reserve(Node list) {
        Node currentNode = list;
        Node previousNode = null;
        Node headNode = null;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            //链表只有一个节点，则直接返回
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }

    //练习 -单链表反转
    public static Node myreserve(Node list) {
        Node currentList = list;
        Node preNode = null;
        Node nextNode;
        while (currentList != null) {
            nextNode = currentList.next;
            //链表反转时，先驱节点变为后置节点
            currentList.next = preNode;
            preNode = currentList;
            currentList = nextNode;
        }
        return preNode;
    }

    //删除倒数第k个节点
    public static Node deleteLastKth(Node list, int k) {
        int length = 0;
        Node node = list;
        while (node != null) {
            node = node.next;
            length++;
        }
        //找出顺序的索引位置
        int index = length - k + 1;
        Node head = list;
        for (int i = 0; i < index - 2; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return list;
    }

    /**
     * 检测链表中是否有环,快慢指针法
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(Node head) {
        if (head == null)
            return false;
        //定义快慢指针为头结点
        Node slowNode = head;
        Node fastNode = head;
        boolean hasCycle = false;
        //加校验避免空指针
        while (slowNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }

    /**
     * 合并俩有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Node mergeList = null;
        Node head = null;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                //初始化mergeList
                if (mergeList == null) {
                    mergeList = new Node(l1.data, null);
                    l1 = l1.next;
                    head = mergeList;
                    continue;
                }
                mergeList.next = new Node(l1.data, null);
                mergeList = mergeList.next;
                l1 = l1.next;
            } else {
                //初始化mergeList
                if (mergeList == null) {
                    mergeList = new Node(l2.data, null);
                    l2 = l2.next;
                    head = mergeList;
                    continue;
                }
                mergeList.next = new Node(l2.data, null);
                mergeList = mergeList.next;
                l2 = l2.next;
            }
        }
        if (l1 != null)
            mergeList.next = l1;
        if (l2 != null)
            mergeList.next = l2;
        return head;
    }

    public static Node mergeTwoLists_2(Node l1, Node l2) {
       if(l1==null){
         return l2;
         }
      if(l2==null){
         return l1;
         }
        Node merged=null;
        Node currt=null;
       //获取头结点
       if(l1!=null&&l2!=null){
          if(l1.data<l2.data){
             merged=l1;
             l1=l1.next;
           }else{
             merged=l2;
             l2=l2.next;
           }
         }
      currt=merged;
      while(l1!=null&&l2!=null){
         if(l1.data<l2.data){
            currt.next=l1;
            l1=l1.next;
         }else{
            currt.next=l2;
           l2=l2.next;
          }
        currt=currt.next;
      }

    if(l1!=null){
      currt.next=l1;
     }
    if(l2!=null){
      currt.next=l2;
     }
     return merged;
     }

    /**
     * 旋转链表，将链表所有节点旋转k位
     * @param head
     * @param k
     * @return
     */
    public Node rotateRight(Node head, int k) {
      return null;
    }















    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;

    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) return;

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

        // 可重复删除指定value的代码
    /*
    if (head != null && head.data == value) {
    	head = head.next;
    }
    Node pNode = head;
    while (pNode != null) {
    	if (pNode.next.data == data) {
    		pNode.next = pNode.next.next;
    		continue;
    	}
    	pNode = pNode.next;
    }
    */
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
//        singlyLinkedList.insertToHead(5);
//        singlyLinkedList.insertToHead(4);
//        singlyLinkedList.insertToHead(3);
//        singlyLinkedList.insertToHead(2);
//        singlyLinkedList.insertToHead(1);
//
//        singlyLinkedList.deleteByValue(3);
        Node root1 = new Node(1, null);
        Node l1 = root1;
        l1.next = new Node(2, null);
        l1.next.next = new Node(4, null);
        Node root2 = new Node(1, null);
        Node l2 = root2;
        l2.next = new Node(3, null);
        l2.next.next = new Node(4, null);


        System.out.println(mergeTwoLists_2(l1, l2));
    }

}

