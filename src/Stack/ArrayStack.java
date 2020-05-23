package Stack;

/**
 * Author: listeningrain
 * Date: 2020/5/23 8:53 上午
 * Description: 顺序栈
 */
public class ArrayStack {
    private Object[] items;
    private int count = -1;
    private int MAX_SIZE;

    public ArrayStack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    //入栈
    public boolean push(Object data){
        if(items == null){
            items = new Object[MAX_SIZE];
        }
        if(count == MAX_SIZE-1){
            throw new RuntimeException("栈满了");
        }
        items[++count] = data;
        return true;
    }
    //出栈
    public Object pop(){
        if(null == items || count < 0){
            throw new RuntimeException("栈为空");
        }
        Object result = items[count];
        count--;
        return result;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push("123");
        arrayStack.push("1234");
        arrayStack.push("1235");
        arrayStack.push("1236");
        arrayStack.push("1237");

        System.out.println(arrayStack.pop());
        arrayStack.push("1230");
        System.out.println(arrayStack.pop());
    }
}
