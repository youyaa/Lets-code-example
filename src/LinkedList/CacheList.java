package LinkedList;

/**
 * @Author: listeningrain
 * @Date: 2019-01-16 20:28
 * @Description: 单链表实现LRU缓存淘汰算法
 */
public class CacheList {
    //头节点
    private Node HEAD;
    //尾节点
    private Node TAIL;
    //当前缓存的长度
    private Integer CURRENT_SIZE;
    //缓存的最大长度
    private Integer MAX_SIZE;

    //初始化
    public CacheList() {
        //初始化头尾节点为null
        HEAD = TAIL = new Node(null, null);
        CURRENT_SIZE = 0;
        MAX_SIZE = 10;
    }

    //初始化时设置缓存长度
    public CacheList(Integer MAX_SIZE) {
        HEAD = TAIL = new Node(null, null);
        CURRENT_SIZE = 0;
        this.MAX_SIZE = MAX_SIZE;
    }

    //放入缓存中
    public Boolean put(Integer key, Integer value) {
        //缓存已满，删除最后一个节点
        if (CURRENT_SIZE == MAX_SIZE) {
            System.out.println("缓存满咯，删除一个");
            //找到尾节点的前一个节点
            Node next = HEAD;
            while (null != next) {
                if (next.next == TAIL) {
                    //删除最后一个节点
                    System.out.println("删除的节点key=" + TAIL.key + " value=" + TAIL.value);
                    next.next = null;
                    TAIL = next;
                    break;
                }
                next = next.next;
            }
            CURRENT_SIZE--;
        }

        Node Node = new Node(key, value);
        Node next = HEAD.next;
        HEAD.next = Node;
        Node.next = next;
        if (HEAD == TAIL) {
            TAIL = Node;
        }

        CURRENT_SIZE++;

        return true;
    }

    //取缓存值
    public Integer get(Integer key) {
        boolean flag = false;
        Integer result = null;
        Node next = HEAD;
        if (null != HEAD) {
            while (null != next) {
                if (key.equals(next.key)) {
                    flag = true;
                    result = next.value;
                }
                next = next.next;
            }
        }

        if (true == flag) {
            //缓存中存在，先删除原位置的节点，再插入到第一个位置
            Node next3 = HEAD;
            while (null != next3) {
                if (key.equals(next3.next.key)) {
                    //删除
                    Node old = next3.next;
                    next3.next = old.next;
                    if (next3.next == TAIL) {
                        TAIL = next3;
                    }
                    //插入第一位
                    Node next2 = HEAD.next;
                    HEAD.next = old;
                    old.next = next2;
                    break;
                }
                next3 = next3.next;
            }
        }
        return result;
    }


    //打印链表
    public void printList() {
        if (null == HEAD) {
            return;
        }
        Node Node = HEAD;
        while (Node != null) {
            System.out.print("key:" + Node.key + " value:" + Node.value);
            if (null != Node.next) {
                System.out.print(" --> ");
            }
            Node = Node.next;
        }
    }


    public static void main(String[] args) {
        CacheList cacheList = new CacheList(2);
        cacheList.put(12, 12);
        cacheList.put(13, 14);
        cacheList.put(43, 56);

        System.out.println("------------取值前----------");
        cacheList.printList();

        System.out.println();
        System.out.println("------------取值中-----------");
        Integer integer = cacheList.get(15);
        System.out.println(integer);

        System.out.println("缓存中不存在，放入缓存");
        cacheList.put(15, 56);

        System.out.println("------------取值后----------");
        cacheList.printList();
        System.out.println();

        System.out.println("--------再次放-------");
        cacheList.put(100,1000);
        cacheList.printList();

        System.out.println("--------再次放-------");
        cacheList.put(111,1111);
        cacheList.printList();

    }

}


/**
 * 单链表的定义
 */
class Node {
    public Integer key;
    public Integer value;
    //下一个节点的指针
    public Node next = null;

    public Node() {
    }

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}