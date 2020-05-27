package Queue;

/**
 * 自己实现的顺序队列
 */
public class ArrayQueue01 {
    private int MAX_SIZE;  //当前队列的长度
    private int HEAD;    //对头指示
    private int TAIL;  //队尾指示
    private int[] items; 

    public ArrayQueue01(int MAX_SIZE){
        this.MAX_SIZE = MAX_SIZE;
        items = new int[MAX_SIZE];
        HEAD = TAIL = 0;
    }

    //入队
    public boolean push(int data){
        if(TAIL == MAX_SIZE){
            if(HEAD == 0){
                throw new RuntimeException("队列已满");
            }
            //有空闲位置，数据搬迁
            int j=0;
            for(int i=HEAD; i<MAX_SIZE; i++,j++){
                items[j] = items[i];
            }
            TAIL = TAIL - HEAD;
            HEAD = 0;
        }
        items[TAIL] = data;
        TAIL++;
        return true;
    }
    //出队
    public int pop(){
        int res = items[HEAD];
        HEAD++;
        return res;
    }

    public static void main(String[] args) {
        ArrayQueue01 arrayQueue01 = new ArrayQueue01(5);
        arrayQueue01.push(1);
        arrayQueue01.push(2);
        arrayQueue01.push(3);
        arrayQueue01.push(4);
        arrayQueue01.push(5);
        System.out.println(arrayQueue01.pop());
        System.out.println(arrayQueue01.pop());
        System.out.println(arrayQueue01.pop());
        arrayQueue01.push(6);
        arrayQueue01.push(7);
        arrayQueue01.push(8);
        System.out.println(arrayQueue01);
        arrayQueue01.pop();
        arrayQueue01.push(9);
        System.out.println(arrayQueue01);
    }
}