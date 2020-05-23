package LinkedList;


/**
 * Author: listeningrain
 * Date: 2020/5/22 2:18 下午
 * Description: 单链表
 */
public class SingleList {
    private int size; //链表的长度
    private Node head;
    private Node tail;

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
    public String get(int postion){
        if(postion<0 || postion>size-1){
            throw new IllegalArgumentException("参数有误");
        }
        int i=0;
        Node result = head;
        while (i!=postion){
            result = result.next;
            i++;
        }
        return result.data;
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

    private static class Node{
        private String data;
        private Node next;  //下一个位置的指针

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
        singleList.it();
        singleList.insert("0000",4);
        singleList.it();
        singleList.insert("哈哈哈",3);
        singleList.it();
        singleList.remove(0);
        singleList.it();
        singleList.remove(3);
        singleList.it();
        singleList.remove(singleList.size-1);
        singleList.it();
    }
}
