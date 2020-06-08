package Digui;

/**
 * Author: listeningrain
 * Date: 2020/6/5 3:37 下午
 * Description: 递归(求斐波拉契数列)
 */
public class Digui {
    public static void main(String[] args) {
        /**
         * 斐波拉契数列 1 1 2 3 ...
         * 递归公式为 F(N) = F(N-1)+F(N-2)
         * F(1) = 1  F(2) = 1
         */
        System.out.println(cal(20));
    }

    public static int cal(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        return cal(n-1)+cal(n-2);
    }
}
