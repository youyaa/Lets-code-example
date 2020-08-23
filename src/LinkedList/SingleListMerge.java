package LinkedList;

/**
 * Author: listeningrain
 * Date: 2020/5/26 8:08 下午
 * Description: 两个有序链表合并
 */
public class SingleListMerge {

    public static void main(String[] args) {
        SingleList.Node node = buildSingleList1();
        SingleList.Node node1 = buildSingleList2();
        SingleList.Node merge = merge(node1, node);
        while (merge != null){
            System.out.print(merge.data+"->");
            merge = merge.next;
        }
    }

    //合并两个有序链表
    private static SingleList.Node merge(SingleList.Node head1, SingleList.Node head2){
        SingleList.Node head = new SingleList.Node(null,null);
        SingleList.Node param = head;

        while (head1 != null && head2 != null){
            //节点同时不为空时遍历
            if (Integer.parseInt(head1.data) <= Integer.parseInt(head2.data)){
                param.next = head1;
                param = param.next;
                head1 = head1.next;
            }else{
                param.next = head2;
                param = param.next;
                head2 = head2.next;
            }
        }
        if(head1 != null){
            param.next = head1;
        }else{
            param.next = head2;
        }
        return head.next;
    }

    private static SingleList.Node buildSingleList1(){
        SingleList singleList = new SingleList();
        singleList.insert("1");
        singleList.insert("123");
        singleList.insert("334");
        return singleList.getHead();
    }
    private static SingleList.Node buildSingleList2(){
        SingleList singleList = new SingleList();
        singleList.insert("45");
        singleList.insert("56");
        singleList.insert("100");
        return singleList.getHead();
    }
}
