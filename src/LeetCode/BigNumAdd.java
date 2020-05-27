package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: youyaa
 * @Date: 2020/5/21 9:01 下午
 * @Description: 大字符串数字加法
 */
public class BigNumAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        String s1 = numAdd(split[0], split[1]);
        System.out.println(s1);
    }


    private static String numAdd(String value1, String value2){
        //先对齐补零
        if(value1.length()>value2.length()){
            StringBuilder stringBuilder = new StringBuilder();
            int i=0;
            while (value1.length()-i != value2.length()){
                stringBuilder.append("0");
                i++;
            }
            value2 = stringBuilder.toString()+value2;
        }
        if(value2.length()>value1.length()){
            StringBuilder stringBuilder = new StringBuilder();
            int i=0;
            while (value2.length()-i != value1.length()){
                stringBuilder.append("0");
                i++;
            }
            value1 = stringBuilder.toString()+value1;
        }
        //从末位向前计算
        int jinwei=0;
        List<Integer> list = new ArrayList<>(300);
        for(int i=value1.length()-1; i>=0; i--){
            int c1 = value1.charAt(i) - '0';
            int c2 = value2.charAt(i) - '0';
            int result = c1+c2+jinwei;    //加上后一位的进位
            jinwei = 0;   //计算完毕置为0
            if(result-10>=0){
                list.add(result-10);
                jinwei = 1;
            }else{
                list.add(result);
            }
        }
        //结束后，判断进位是否是1
        if(jinwei == 1){
            list.add(1);
        }
        //返回最终结果
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}
