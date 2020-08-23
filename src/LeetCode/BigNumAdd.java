package LeetCode;

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
        String s1 = addStrings(split[0], split[1]);
        System.out.println(s1);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder StringBuilder = new StringBuilder();
        if(num1.length()>num2.length()){
            int big = num1.length() - num2.length();
            for(int i=0; i<big; i++){
                StringBuilder.append("0");
            }
            num2 = StringBuilder.toString()+num2;
        }else{
            int big = num2.length() - num1.length();
            for(int i=0; i<big; i++){
                StringBuilder.append("0");
            }
            num1 = StringBuilder.toString()+num1;
        }
        System.out.println(num1+","+num2);
        int jinwei = 0;
        StringBuilder s = new StringBuilder();
        for(int i=num1.length()-1; i>=0; i--){
            int p1 = num1.charAt(i) - '0';
            int p2 = num2.charAt(i) - '0';
            int result = p1 + p2 + jinwei;
            jinwei = 0;
            if(result - 10 >= 0){
                s.append(result - 10);
                jinwei = 1;
            }else{
                s.append(result);
            }
        }
        if(jinwei == 1){
            s.append("1");
        }
        return s.reverse().toString();
    }
}
