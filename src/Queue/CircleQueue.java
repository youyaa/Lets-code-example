package Queue;

/**
 * Author: listeningrain
 * Date: 2020/6/5 2:54 下午
 * Description: 循环队列
 */
public class CircleQueue {
    private int[] nums;
    private int n;  //队列总大小
    private int head;
    private int tail;

    public CircleQueue(int n) {
        this.n = n;
        nums = new int[n];
        head = tail = 0;
    }

    //入队
    public void push(int data){
        if((tail+1)%n == head){
            throw new RuntimeException("队列已满");
        }
        nums[tail] = data;
        if(tail == n-1){
            tail = 0;
        }else
            tail = tail + 1;
    }

    //出队
    public int pop(){
        if(head == tail){
            throw new RuntimeException("队列为空");
        }
        int data = nums[head];
        if(head == n-1)
            head = 0;
        else
            head = head +1;
        return data;
    }

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(5);
        circleQueue.push(1);
        circleQueue.push(2);
        circleQueue.push(3);
        circleQueue.push(4);

        //circleQueue.push(5);
        System.out.println(circleQueue.pop());
        circleQueue.push(5);
        System.out.println(circleQueue.pop());
        System.out.println(circleQueue.pop());
        System.out.println(circleQueue.pop());
        System.out.println(circleQueue.pop());
        System.out.println(circleQueue.pop());
    }
}
