package Tree;


import java.util.LinkedList;

/**
 * Author: listeningrain
 * Date: 2020/6/7 3:14 下午
 * Description: 二叉查找树
 */
public class BinarySearchTree {
    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = tree; // p指向要删除的节点，初始化指向根节点
        Node pp = null; // pp记录的是p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没有找到

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p; // minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; // 将minP的数据替换到p中
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    public Node findMin() {
        if (tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    //前序遍历
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+",");
        preOrder(node.left);
        preOrder(node.right);
    }
    //中序遍历
    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+",");
        inOrder(node.right);
    }
    //后序遍历
    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+",");
    }
    /**
     * 二叉树的层序遍历 借助于队列来实现 借助队列的先进先出的特性
     *
     * 首先将根节点入队列 然后遍历队列。
     * 首先将根节点打印出来，接着判断左节点是否为空 不为空则加入队列
     * @param node
     */
    public void levelIterator(Node node){
        LinkedList<Node> queue = new LinkedList<>() ;

        //先将根节点入队
        queue.offer(node) ;
        Node current ;
        while (!queue.isEmpty()){
            current = queue.poll();

            System.out.print(current.data+"--->");

            if (current.left != null){
                queue.offer(current.left) ;
            }
            if (current.right != null){
                queue.offer(current.right) ;
            }
        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);

        //System.out.println(binarySearchTree.find(5).data);
        binarySearchTree.preOrder(binarySearchTree.tree);
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.tree);
        System.out.println();
        binarySearchTree.postOrder(binarySearchTree.tree);
    }
}
