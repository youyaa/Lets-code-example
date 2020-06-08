package LeetCode;

/**
 * Author: listeningrain
 * Date: 2020/6/7 9:23 上午
 * Description: 求一个数的平方根（近似解，精确小数点后几位）
 */
public class SqrtCal {

    public static void main(String[] args) {
        System.out.println(sqrt(10000.0,0));
    }

    public static double sqrt(double x, double precision) {
        if (x < 0) {
            return Double.NaN;
        }
        double low = 0;
        double up = x;
        if (x < 1 && x > 0) {
            /** 小于1的时候*/
            low = x;
            up = 1;
        }
        double mid = low + (up - low) / 2;
        while (up - low > precision) {
            if (mid * mid > x) {//TODO mid可能会溢出
                up = mid;
            } else if (mid * mid < x) {
                low = mid;
            } else {
                return mid;
            }
            mid = low + (up - low) / 2;
        }
        return mid;
    }
}
