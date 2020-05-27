package Stack;


/**
 * Author: listeningrain
 * Date: 2020/5/27 10:35 上午
 * Description: 链式栈(不想写了)
 */
public class LinkedListStack {

    private Node head;
    private Node tail;

    public boolean push(String data){
        if(null == head){
            head = new Node(null,null);
            tail = new Node(null,null);
            Node node = new Node(data);
            tail = node;
            head = node;
        }else{
            Node node = new Node(data);
            tail.next = node;
            tail = node;
        }
        return true;
    }

    public Node pop(){
        return null;
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
}
