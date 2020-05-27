package LinkedList;


import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: listeningrain
 * Date: 2020/5/22 2:18 下午
 * Description: 单链表
 */
public class SingleList {
    private int size; //链表的长度
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    //插入,默认采用尾插法
    public boolean insert(String data){
        if(null == data){
            throw new NullPointerException("数据不能为null");
        }
        if(head == null){
            //链表不存在则构建
            head = tail = new Node(null,null);
            Node node = new Node(data);
            head = tail = node;
        }else {
            //链表存在，插入尾部
            Node node = new Node(data);
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }
    //在指定位置插入
    public boolean insert(String data, int postion){
        if(null == data){
            throw new IllegalArgumentException("数据不能为null");
        }
        if(postion < 0){
            throw new IllegalArgumentException("位置参数有误");
        }
        //插入第一个位置
        if(postion == 0){
            Node node = new Node(data);
            node.next = head;
            head = node;
        }else if(postion>size-1){
            //超过最大下标
            Node node = new Node(data);
            tail.next = node;
            tail = node;
        }else{
            //其他情况遍历到position的前一个节点
            Node first = head;
            int i=0;
            while (i+1 != postion){
                first = first.next;
                i++;
            }
            Node node = new Node(data);
            node.next = first.next;
            first.next = node;
        }
        size++;
        return true;
    }
    //获取某个值
    public Node get(int postion){
        if(postion<0 || postion>size-1){
            throw new IllegalArgumentException("参数有误");
        }
        int i=0;
        Node result = head;
        while (i!=postion){
            result = result.next;
            i++;
        }
        return result;
    }
    //遍历输出
    public void it(){
        Node first = head;
        while (first != null){
            System.out.print(first.data+"->");
            first = first.next;
        }
        System.out.println();
    }
    //删除某个节点
    public boolean remove(int position){
        if(position<0 || position>size-1){
            throw new IllegalArgumentException("参数有误");
        }
        if(0 == position){
            //删除第一个节点
            Node first = head;
            head = head.next;
            first.next = null;
        } else {
            int i=0;
            Node result = head;
            while (i+1!=position){
                result = result.next;
                i++;
            }
            if(result.next == tail){
                //删除最后一个节点需要改变tail的位置
                tail = result;
                result.next = null;
            }else{
                result.next = result.next.next;
            }
        }
        size--;
        return true;
    }
    //反转链表
    public void reverse(){
        if(head == null){
            throw new RuntimeException("数组为空");
        }
        Node front = head;
        Node behind = head.next;
        //直接把第一个节点的next置为null
        front.next = null;
        while (behind != null){
            Node newBehind = behind.next;
            behind.next = front;
            front = behind;
            behind = newBehind;
        }
        //交换head和tail节点
        Node cur = head;
        head = tail;
        tail = cur;
    }
    //求链表的中间节点
    public Node getMiddle(){
        Node quick = head;
        Node slow = head;
        //快慢指针，同时遍历，快指针一次走两格，慢指针一次走一格
        while (true){
            if(quick.next == null){
                return slow;
            }else if(quick.next.next == null){
                //偶数个节点返回第二个节点
                return slow.next;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
    }
    //链表中环的检测
    public boolean checkCircle(){
        Set<Node> hashSet = new HashSet();
        while (head != null){
            if(hashSet.contains(head)){
                return true;
            }else{
                hashSet.add(head);
            }
            head = head.next;
        }
        return false;
    }


    public static class Node{
        public String data;
        public Node next;  //下一个位置的指针

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.insert("123");
        singleList.it();
        singleList.insert("1234");
        singleList.it();
        singleList.insert("12",0);
        singleList.it();
        singleList.insert("1",0);
        singleList.it();
        singleList.insert("12345");
        singleList.insert("哈哈哈哈");
        singleList.insert("344");
        singleList.it();
        System.out.println("----------求中间节点---------");
        System.out.println(singleList.getMiddle().data);
        singleList.get(1).next = singleList.head;
        System.out.println("----------检测环---------");
        System.out.println(singleList.checkCircle());
        //反转
        /*System.out.println("-----------");
        singleList.reverse();
        singleList.it();*/
        /*singleList.insert("0000",4);
        singleList.it();
        singleList.insert("哈哈哈",3);
        singleList.it();
        singleList.remove(0);
        singleList.it();
        singleList.remove(3);
        singleList.it();
        singleList.remove(singleList.size-1);
        singleList.it();*/
    }
}
